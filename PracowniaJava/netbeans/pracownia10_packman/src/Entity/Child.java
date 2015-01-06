package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;
import java.util.Random;

public class Child extends Movable
{
    public Child(Game p_gameInstance, EntitiesPositions p_board)
    {
        m_board = p_board;
        randomlyPutChild();
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        p_screen.applySprite(m_posX, m_posY, selectChildImage());
    }
    
    private Sprite selectChildImage()
    {
        if (isSleeping())
            return SpriteContainer.s_childSleeping;
        else
            return SpriteContainer.s_child;
    }
    
    private void randomlyPutChild()
    {
        Random l_random = new Random();
        while(true)
        {
            Boolean l_setStatus = setPosition(
                1 + l_random.nextInt(Game.s_gameWidth -2),
                1 + l_random.nextInt(Game.s_gameHeight-2));
            if(l_setStatus) break;
        }
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
    
    public boolean isSleeping()
    {
        return m_childIsSleeping;
    }
    
    public Moves moveTowardSanta()
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
                    return Moves.up;
                }
                else
                {
                    return Moves.left;
                }
            }
            else
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return Moves.down;
                }
                else
                {
                    return Moves.left;
                }
            }
        }        
        else
        {
            if (l_santaY < m_posY)
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return Moves.up;
                }
                else
                {
                    return Moves.right;
                }
            }
            else
            {
                if(Math.abs(m_posX - l_santaX) < Math.abs(m_posY - l_santaY))
                {
                    return Moves.down;
                }
                else
                {
                    return Moves.right;
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
        //m_childIsSleeping = false;
    }
    
    private boolean m_childIsSleeping = false;
    private boolean m_childIsHappy = false;
    private final int m_childScope = 5;
}
