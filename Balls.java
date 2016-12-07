import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Balls {
   
   private Timer timer = new Timer(50, new TimeListener());
   private BallPanel p = new BallPanel();
   private Ball b = new Ball(); 
   private ArrayList<Ball> list = new ArrayList<Ball>(1);
   //private shipX
   
   
   Balls(){
      
      JFrame frame = new JFrame(); 
      frame.add(p); 
      frame.setSize(700, 700);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      timer.start(); 
   }//end Balls class constructor

   public static void main(String[] args){
   
      new Balls();
   
   }//end main method
   
   class BallPanel extends JPanel {
      
      private char keyChar = 'A';
      
      BallPanel(){
         addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
               keyChar = e.getKeyChar();
               System.out.println(keyChar);
            }
         });
      
      }//end ball panelconstructor
      
      public void paintComponent (Graphics g) {
         g.setColor(Color.black); 
         g.fillRect(0 ,0, this.getWidth(), this.getHeight());
         g.setColor(Color.yellow); 
         g.fillOval(500, 100, 100, 100); 
         g.setColor(Color.red); 
         //g.fillArc(this.getWidth() / 2 - 100,  this.getHeight() / 2 - 100, 300, 300, 270, 30);
         for(int i = 0; i < list.size(); i++){
            g.setColor(list.get(i).color); 
            g.fillOval(list.get(i).x, list.get(i).y, 2, 2); 
         }
      }
      
      public void pos() {
         System.out.println(this.getWidth() / 2 + " " + this.getHeight() / 2);
      }
   }
   
   class Ball {
      int x;
      int y;
      boolean direction = false; 
      Color color;
      
      Ball(){   
         x = (int)(Math.random() * 682); 
         y = -50; 
         direction = false; 
         //color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
         color = Color.white;
      }
       
   }//end ball class
   
   
   class TimeListener implements ActionListener {

      public void actionPerformed(ActionEvent e) {
         
         /*
         if(b.y == -10)
            b.direction = false;
         
         if(b.y == 300)
            b.direction = true;
            
         if(b.direction == false) 
            b.y++; 
         
         else
            b.y--;
         */
         for(int i = 0; i < list.size(); i++){
            list.get(i).y++; 
         }
         
         list.add(new Ball());
          
         p.repaint(); 
      }
   }//end time listener class
   
   
}//end class