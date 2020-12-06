package multithread;

import java.util.logging.Level;
import java.util.logging.Logger;
import multithread.werkClass;

public class MultiThread 
{
    werkClass werkObject[] = new werkClass[3]; //Create an array of 3 threads
    Thread instructor[] = new Thread[3];
    
    public MultiThread()
    {
        for (int count = 0; count < werkObject.length; count++)
        {
            werkObject[count] = new werkClass("main", 13, count);
            instructor[count] = new Thread(werkObject[count]);
        }
    }

    public static void main(String[] args) 
    {
        long ourTime;

        MultiThread myThis = new MultiThread();
        
        for(int count = 0; count < myThis.instructor.length; count++)
        { 
            myThis.instructor[count].start();
        }

        do
        {
            System.out.println("thread 1 is still alive");
            ourTime = System.currentTimeMillis();
        }
        while (myThis.instructor[0].isAlive());
    
        try 
        {
            myThis.instructor[0].join();
        } 
        catch (InterruptedException ex) 
        {
        Logger.getLogger(MultiThread.class.getName())
                .log(Level.SEVERE, null, ex);
        }
        
        System.out.println("final = " + myThis.werkObject[0].getResult());
    }
}