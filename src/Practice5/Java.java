package Practice5;

import java.awt.*;
import javax.swing.*;


public class Java extends JFrame{
    private static MyPanel panel = new MyPanel();

    public Java(){
        setTitle("이미지 일부분 크기 조절하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500,500);
        setVisible(true);

    }

    static class MyPanel extends JPanel{
        ImageIcon icon = new ImageIcon("C:/Users/한석훈/Pictures/Screenshots/스크린샷 2023-10-25 183236.png");
        Image img =icon.getImage();

        public void paintComponent(Graphics g){
           super.paintComponent(g);
           g.drawImage(img,0,0,getWidth(),getHeight(),this);
        }
    }
    public static void main(String[] args){
        new Java();
    }
}