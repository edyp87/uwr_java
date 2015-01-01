package Threads;

import Entity.Child;
import Santa.Game;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChildThread implements Runnable
{
    public ChildThread(Child p_child)
    {
        m_child = p_child;
        Random l_random = new Random();
        
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
        m_bedTimeInMs = 2000 + l_random.nextInt(3000);
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            m_child.playTime();
            
            switch(selectBehavior())
            {
                case 0:
                    m_child.moveUp();
                    break;
                case 1:
                    m_child.moveRight();
                    break;
                case 2:
                    m_child.moveDown();
                    break;
                case 3:
                    m_child.moveLeft();
                    break;
                case 4:
                    System.out.println("SLEEP");
                    m_child.napTime();
                    waitInMilisec(m_bedTimeInMs);
            }
            
            waitInMilisec(m_waitTimeInMs);
        }
    }
    
    private int selectBehavior()
    {
        Random l_random = new Random();
        int l_behavior = l_random.nextInt(50);
        
//        if (l_behavior < 40 && m_child.iSeeSanta() != 4)
//        {
//            return m_child.iSeeSanta();
//        }
//        
        if(l_behavior < 10)
            return 0;
        else if(l_behavior < 20)
            return 1;
        else if(l_behavior < 30)
            return 2;
        else if(l_behavior < 40)
            return 3;
        else
            return 4;
    }
    
    private void waitInMilisec(int p_milisec)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(p_milisec);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Game.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private Child m_child;
    private int m_waitTimeInMs;
    private int m_bedTimeInMs;
}