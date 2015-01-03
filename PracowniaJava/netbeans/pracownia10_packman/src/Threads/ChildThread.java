package Threads;

import Entity.Child;
import Santa.Game;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ChildThread implements Runnable
{
    private final int m_waitTimeInMs;
    private final int m_bedTimeInMs;
    public ChildThread(Child p_child , SynchroClass p_synchroClass)
    {
        m_child = p_child;
        m_synchroClass = p_synchroClass;
                Random l_random = new Random();
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
        m_bedTimeInMs = 2000 + l_random.nextInt(1000);
    }
    
    @Override
    public void run()
    {
        
        while(m_child.isChildSeekingForPresents())
        {   
            //synchronized(m_synchroClass)
            {
                if(m_synchroClass.handleChild(m_child))
                {
                    waitInMilisec(m_bedTimeInMs);
                }
                Thread.yield();
                if(!m_synchroClass.wakeChildUpIfSleeping(m_child))
                {
                    waitInMilisec(m_waitTimeInMs);
                }Thread.yield();
            }
        }
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
    
    private final Child m_child;
    private final SynchroClass m_synchroClass;
}
