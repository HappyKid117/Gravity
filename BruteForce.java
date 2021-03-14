import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class BruteForce extends JFrame{
    public int N = 4;
    public Body bodies[]= new Body[10000];  
    int max = 500;
    int min = -500;
    BruteForce(){
        setSize(1000,1000);
        setVisible(true);
    }

    public void startthebodies(int N) {
        double solarmass=1.98892e30;
        for (int i = 0; i < N; i++) {
            //double px = Math.random() * (max - min + 1) + min;
            //double py = Math.random() * (max - min + 1) + min;
            double px,py;
            double mass = 5;
            double vx = 0;
            double vy = 0;
            /**/
            if(i==0){
                px = 0;
                py = -100;
                vx = 0.5;
            }else if(i==1){
                px = 100;
                py = 0;
                vy = 0.5;
            }else if(i==2){
                px = 0;
                py = 100;
                vx = -0.5;
            }else{
                px = -100;
                py = 0;
                vy = -0.5;
            }
            /**/
            bodies[i]   = new Body(px, py, vx, vy, mass);
        }
        //bodies[N-1] = new Body(0, 0, 0, 0, 9000000);
    }

    public void addforces(int N) {
        for (int i = 0; i < N; i++) {
          bodies[i].resetForce();
          //Notice-2 loops-->N^2 complexity
          for (int j = 0; j < N; j++) {
            if (i != j) bodies[i].addForce(bodies[j]);
          }
        }
        //Then, loop again and update the bodies using timestep dt
        for (int i = 0; i < N; i++) {
          bodies[i].update(1);
        }
        
    }

    public void paint(Graphics g){
    super.paint(g);
    g.translate(500,500); //Originally the origin is in the top right. Put it in its normal place
    if(true){
      for(int i=0; i<N; i++) {
        g.fillOval((int) Math.round(bodies[i].rx),(int) Math.round(bodies[i].ry),25,25);
      }
      addforces(N);
    }
  }

    public static void main(String[] args){
        BruteForce b = new BruteForce();
        b.setVisible(true);
        b.startthebodies(4);
        while(true){
            b.repaint();
            try{
                Thread.sleep(1);
            }catch(Exception e){}
        }
    } 
}
