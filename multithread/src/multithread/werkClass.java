package multithread;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

class werkClass extends JFrame implements Runnable{
    
    Random random = new Random();
    
    private int num1, result, x_pos, x_dist, x_speed, number = 0;
    private String name = "default";
    private String ourText;
    private long ourTime;
    

    //This is our first thread
    werkClass(int input) 
    {
        num1 = input;
    }

    werkClass(String name, int input, int number) {
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.name = name;
        this.number = number;
        num1 = input;
        this.setLocation(number*100, number*100);
        x_speed = random.nextInt(25);
    }

    public int getNum() 
    {
        return num1;
    }

    public int getResult() 
    {
        return result;
    }

    @Override
    public void run() 
    {
        while (true)
        {
          ourTime = System.currentTimeMillis();
          ourTime = ourTime / 50 * x_speed;
          x_pos = (int) (ourTime % 400);
          x_dist = 200 - x_pos;
          ourText = Integer.toString(x_dist);
          repaint();
        }
        
        
   
    }
    
    @Override
    public void paint(Graphics graph){
        super.paint(graph);
        graph.drawOval(x_pos, 100, 50, 50);
        graph.drawString(ourText, 200, 150);
    }
    
}
