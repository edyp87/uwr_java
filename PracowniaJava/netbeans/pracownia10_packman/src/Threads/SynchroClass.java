/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Entity.Child;
import Entity.Player;
import Santa.Game;
import Santa.InputHandler;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 *
 * @author Marek
 */
public class SynchroClass
{
    private final int m_waitTimeInMs;
    private final int m_bedTimeInMs;
    public SynchroClass()
    {
        
        Random l_random = new Random();
        m_waitTimeInMs = 500 + l_random.nextInt(1500);
        m_bedTimeInMs = 2000 + l_random.nextInt(1000);
    }
    
    public synchronized boolean handleChild(Child m_child)
    {
            boolean l_bed = false;
                switch(selectBehavior(m_child))
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
                        m_child.napTime();
                        l_bed = true;
                }
            return l_bed;

    }

    public synchronized boolean wakeChildUpIfSleeping(Child m_child)
    {
        if(m_child.isChildSleeping())
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
    
    public void handlePainter() {}

    private int selectBehavior(Child m_child)
    {
        Random l_random = new Random();
        int l_behavior = l_random.nextInt(50);

        if(m_child.isSantaInRadius() && l_behavior < 40)
        {
            return m_child.moveTowardSanta();
        }
        
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
}
