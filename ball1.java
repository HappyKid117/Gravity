import javax.swing.JFrame;

import java.awt.*;

public class ball1 extends JFrame {
    int x = 50;
    int y = 50;
    int rad = 50;

    ball1(){
        setTitle("Gravity");
        setSize(500, 500);
        setVisible(true); 
    }

    public void paint(Graphics G){
        super.paint(G);
        G.fillOval(x, y, rad, rad);
    }

    void move(){
        if(x<getHeight()-rad){
            y = y+1;
        }
        
    }

    public static void main(String[] args){
        ball1 b = new ball1();
        while(true){
            b.move();
            b.repaint();
            try{
                Thread.sleep(100);
            }catch(Exception e){}
        }
    }  
}
