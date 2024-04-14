package game;

import javax.swing.*;

public class App extends JFrame{
    public static void main(String[] args) throws Exception{
        int boardWidth = 600;
        int boardHeight = 600;

        JFrame frame = new JFrame("snake game");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Game game = new Game(boardWidth,boardHeight);
        frame.add(game);
        frame.pack();
        game.requestFocus();
    }
}
