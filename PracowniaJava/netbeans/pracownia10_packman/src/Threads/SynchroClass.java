package Threads;

import Entity.Child;
import Entity.Entity.Moves;
import Entity.Player;
import static Entity.Entity.Moves.*;
import Santa.InputHandler;
import java.util.Random;

public class SynchroClass
{
    public SynchroClass()
    {
        
        Random l_random = new Random();
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
        m_bedTimeInMs = 2000 + l_random.nextInt(1000);
    }
    
    public synchronized boolean handleChild(Child m_child)
    {
            boolean l_bedTime = false;
                switch(selectBehavior(m_child))
                {
                    case up:
                        m_child.moveUp();
                        break;
                    case right:
                        m_child.moveRight();
                        break;
                    case down:
                        m_child.moveDown();
                        break;
                    case left:
                        m_child.moveLeft();
                        break;
                    case end:
                        m_child.napTime();
                        l_bedTime = true;
                }
            return l_bedTime;

    }

    public synchronized boolean wakeChildUpIfSleeping(Child m_child)
    {
        if(m_child.isSleeping())
        {
            m_child.wakeUp();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public synchronized void handlePlayer(Player p_player, InputHandler p_inputHandler)
    {
        if(p_inputHandler.m_up)          p_player.moveUp();
        if(p_inputHandler.m_down)        p_player.moveDown();
        if(p_inputHandler.m_left)        p_player.moveLeft();
        if(p_inputHandler.m_right)       p_player.moveRight();
        if(p_inputHandler.m_dropPresent) p_player.dropPresent();
        p_inputHandler.signalReceived();
    }

    private Moves selectBehavior(Child m_child)
    {
        Random l_random = new Random();
        int l_behavior = l_random.nextInt(50);

        if(m_child.isSantaInRadius() && l_behavior < 40)
        {
            return m_child.moveTowardSanta();
        }
        
        if(l_behavior < 10)
            return up;
        else if(l_behavior < 20)
            return right;
        else if(l_behavior < 30)
            return down;
        else if(l_behavior < 40)
            return left;
        else
            return end;
    }
    
    private final int m_waitTimeInMs;
    private final int m_bedTimeInMs;
}
