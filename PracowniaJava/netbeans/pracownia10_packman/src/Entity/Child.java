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
        
        return Math.abs(l_santaX - m_posX) <= 10 && Math.abs(l_santaY - m_posY) <= 10;
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
//        if( m_board.isLonelyPresentNearby(m_posX, m_posY))
//        {
//            if(m_board.isLonelyPresentOnPosition(m_posX-1, m_posY  )) {System.out.println(m_posX + " PREZENT!"); m_board.setPresentOwner(m_posX-1, m_posY  ); moveLeft(); }
//            if(m_board.isLonelyPresentOnPosition(m_posX+1, m_posY  )) {System.out.println(m_posX + " PREZENT!");m_board.setPresentOwner(m_posX+1, m_posY  ); moveRight();}
//            if(m_board.isLonelyPresentOnPosition(m_posX  , m_posY-1)) {System.out.println(m_posX + " PREZENT!");m_board.setPresentOwner(m_posX,   m_posY-1); moveUp();   }
//            if(m_board.isLonelyPresentOnPosition(m_posX  , m_posY+1)) {System.out.println(m_posX + " PREZENT!");m_board.setPresentOwner(m_posX,   m_posY+1); moveDown(); }
//            foundThePresent();
//        }
        if(m_board.grabThePresent(m_posX, m_posY, this)) foundThePresent();
        playTime();
    }
    
    public boolean isChildSeekingForPresents()
    {
        return !m_childIsHappy;
    }
    
    private void foundThePresent()
    {
        System.out.println("ZNALAZLEM!");
        m_childIsHappy = true;
    }
    
    private boolean m_childIsSleeping = false;
    private boolean m_childIsHappy = false;
}
