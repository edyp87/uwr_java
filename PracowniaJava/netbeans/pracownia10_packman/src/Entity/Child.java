package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;
import java.util.Random;

public class Child extends Entity
{
    public Child(Game p_gameInstance, EntitiesPositions p_board)
    {
        m_board = p_board;
        randomlyPutChild();
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        Sprite l_child;
        if(isChildSleeping())
            l_child = SpriteContainer.s_childSleeping;
        else
            l_child = SpriteContainer.s_child;
        p_screen.applySprite(m_posX * p_tileSize, m_posY * p_tileSize, l_child);
    }
    
    private void randomlyPutChild()
    {
        System.out.println("Randomly py child");
        Random l_random = new Random();
        setPosition(1 + l_random.nextInt(Game.s_gameWidth-2),
                    1 + l_random.nextInt(Game.s_gameHeight-2));
    }
    
    public void napTime()
    {
        m_childIsSleeping = true;
    }
    
    public void playTime()
    {
        m_childIsSleeping = false;
    }

    public boolean isSantaInRadius()
    {
        int l_santaPosition = m_board.getSantaPosition();
        int l_santaX = l_santaPosition % Game.s_gameWidth;
        int l_santaY = l_santaPosition / Game.s_gameWidth;
        
        return Math.abs(l_santaX - m_posX) <= m_childScope 
            && Math.abs(l_santaY - m_posY) <= m_childScope;
    }
    
    public boolean isChildSleeping()
    {
        return m_childIsSleeping;
    }
    
    public int moveTowardSanta()
    {
        int l_santaPosition = m_board.getSantaPosition();
        int l_santaX = l_santaPosition % Game.s_gameWidth;
        int l_santaY = l_santaPosition / Game.s_gameWidth;
        
        if(l_santaX < m_posX) //TODO: ifology :)
        {
            if (l_santaY < m_posY)
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return 0;
                }
                else
                {
                    return 3;
                }
            }
            else
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
        }        
        else
        {
            if (l_santaY < m_posY)
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return 2;
                }
                else
                {
                    return 1;
                }
            }
        }   
    }

    public void wakeUp()
    {
        if(!m_board.grabThePresent(m_posX, m_posY, this)) 
            playTime();
    }
    
    public boolean isChildSeekingForPresents()
    {
        return !m_childIsHappy;
    }
    
    public void foundThePresent()
    {
        m_childIsHappy = true;
        m_childIsSleeping = false;
    }
    
    private boolean m_childIsSleeping = false;
    private boolean m_childIsHappy = false;
    private int m_childScope = 5;
}
