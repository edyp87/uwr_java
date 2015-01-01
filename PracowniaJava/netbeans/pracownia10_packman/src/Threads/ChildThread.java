package Threads;

import Entity.Child;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChildThread implements Runnable
{
    public ChildThread(Child p_child)
    {
        m_child = p_child;
        Random l_random = new Random();
        
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            Random l_random = new Random();
            int l_move = l_random.nextInt(4);
            switch(l_move)
            {
                case 0:
                    m_child.moveUp();
                    break;
                case 1:
                    m_child.moveDown();
                    break;
                case 2:
                    m_child.moveLeft();
                    break;
                case 3:
                    m_child.moveRight();
                    break;
            }
            try {
                Thread.sleep(m_waitTimeInMs);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChildThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Child m_child;
    private int m_waitTimeInMs = 500;
}
