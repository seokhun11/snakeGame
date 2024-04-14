package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class Game extends JPanel implements ActionListener, KeyListener {

    private static class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 20;

    Tile snakeHead;  //snake
    ArrayList<Tile> snakeBody;

    Tile food;   // food
    Random random;

    Timer gameLoop;
    int velocityX;
    int velocityY;
    boolean gameOver = false;

    Game(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);

        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<>();

        food = new Tile(10, 10);
        random = new Random();
        placeFood();

        gameLoop = new Timer(100, this); //actionListener
        gameLoop.start(); //actionListener start
    }

    public void paintComponent(Graphics g) {  //actionListener fucntion
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        /*for(int i = 0; i < boardWidth/tileSize; i++){
            g.drawLine(i*tileSize, 0 , i*tileSize, boardHeight);
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
        }
        */

        //snakeHead
        g.setColor(Color.green);
        g.fill3DRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize, true);

        //snakeBody
        for (Tile snakePart : snakeBody) {
            g.fill3DRect(snakePart.x * tileSize, snakePart.y * tileSize, tileSize, tileSize, true);
        }

        //Food
        g.setColor(Color.red);
        g.fill3DRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize, true);

        //Score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.setColor(Color.green);
        g.drawString("Score: " + snakeBody.size() * 10, tileSize - 16, tileSize);
        }

    public void placeFood() {
        food.x = random.nextInt(boardWidth / tileSize);
        food.y = random.nextInt(boardHeight / tileSize);
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void move() {
        // Eat Food
        if (collision(snakeHead, food)) {
            snakeBody.add(new Tile(food.x, food.y)); // arrayList increase
            placeFood();
        }

        //Snake Body
        for (int i = snakeBody.size() - 1; i >= 0; i--) {
            Tile snakePart = snakeBody.get(i);
            if (i == 0) {
                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;
            } else {
                Tile preSnakePart = snakeBody.get(i - 1);
                snakePart.x = preSnakePart.x;
                snakePart.y = preSnakePart.y;
            }
        }

        //SnakeHead
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;

        //GameOver condition
        for (Tile snakePart : snakeBody) {
            if (collision(snakeHead, snakePart)) {
                gameOver = true;
            }
        }

        if (snakeHead.x * tileSize < 0 || snakeHead.x * tileSize > boardWidth
                || snakeHead.y * tileSize < 0 || snakeHead.y * tileSize > boardHeight) {
            gameOver = true;
        }
    }

    // 게임을 재시작하는 메서드
    private void restartGame() {
        // 게임 상태 초기화
        snakeHead = new Tile(5,5);
        snakeBody.clear();
        placeFood();
        gameOver = false;
        velocityX = 0;
        velocityY = 0;

        // 타이머 재시작
        gameLoop.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint(); //Timer Listener
        if (gameOver) {
            gameLoop.stop();
                // 게임 오버 다이얼로그에 스코어 표시
                int score = snakeBody.size() * 10;
                String message = "Game Over\n\nScore: " + score;
                int option = JOptionPane.showConfirmDialog(null, message, "게임 종료", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    // 다시하기 버튼을 누를 경우 게임을 초기화하고 재시작합니다.
                    restartGame();
                } else {
                    // 종료 버튼을 누를 경우 프로그램을 종료합니다.
                    System.exit(0);
                }
            }
        }

    @Override
    public void keyTyped(KeyEvent e) {     //not need
    }

    @Override
    public void keyReleased(KeyEvent e) {    // not need
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1){
            velocityX = 0;
            velocityY = -1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1){
            velocityX = 0;
            velocityY = 1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1){
            velocityX = -1;
            velocityY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
     }
}
