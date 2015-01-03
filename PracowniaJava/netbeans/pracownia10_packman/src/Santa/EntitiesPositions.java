package Santa;

import Entity.Child;
import Entity.Entity;
import Entity.Player;
import Entity.Present;

/**
 * EntitiesPosition handle all entities position on game board.
 * It is also a proxy class when painter want to paint all entities.
 * @author Marek
 */
public class EntitiesPositions
{
    public EntitiesPositions(int p_width, int p_height)
    {
        m_width = p_width;
        m_height = p_height;
        m_board = new Entity[p_width * p_height];
        m_presents = new Present[p_width * p_height];
    }
    
    public synchronized boolean setPosition(int p_x, int p_y, Entity p_entity)
    {
        if(m_board[m_width * p_y + p_x] == null)
        {
            m_board[m_width * p_y + p_x] = p_entity;
            if(p_entity instanceof Child && !((Child)p_entity).isChildSeekingForPresents())
                System.out.println("setPosition: " + p_x  + " " + p_y);
            
            return true;
        }
        return false;
    }
    
    public synchronized boolean dropPresent(int p_x, int p_y, Present p_entity)
    {
        if(m_presents[m_width * p_y + p_x] == null && isNeighboringChildSleeping(p_x, p_y))
        {
            m_presents[m_width * p_y + p_x] = p_entity;
            return true;
        }
        return false;
    }
    
    public synchronized void renderAll(Screen p_screen, int p_tileSize)
    {
        for(Present p_entity : m_presents)
        {
            if(p_entity != null)
            {
                p_entity.render(p_screen, p_tileSize);
            }
        }
                
        for(Entity p_entity : m_board)
        {
            if(p_entity != null)
            {
                p_entity.render(p_screen, p_tileSize);
            }
        }
    }
    
    public synchronized void unsetPosition(int p_x, int p_y)
    {
        m_board[m_width * p_y + p_x] = null;
    }
    
    public synchronized int getSantaPosition()
    {
        for (int i = 0; i < m_board.length; ++i)
        {
            if(m_board[i] != null && m_board[i] instanceof Player)
            {
                return i;
            }
        }
        return -1; //unreachable
    }

    public synchronized boolean isNeighboringChildSleeping(int p_posX, int p_posY)
    {
        return isChildSleeping(p_posX-1, p_posY  )
            || isChildSleeping(p_posX+1, p_posY  )
            || isChildSleeping(p_posX,   p_posY-1)
            || isChildSleeping(p_posX,   p_posY+1);
        
    }
    
    public synchronized boolean isLonelyPresentNearby(int p_posX, int p_posY)
    {
        return isLonelyPresentOnPosition(p_posX-1, p_posY  )
            || isLonelyPresentOnPosition(p_posX+1, p_posY  )
            || isLonelyPresentOnPosition(p_posX,   p_posY-1)
            || isLonelyPresentOnPosition(p_posX,   p_posY+1);
    }
    
    private synchronized boolean isChildSleeping(int p_posX, int p_posY)
    {
        return m_width * p_posY + p_posX < m_board.length
                && m_board[m_width * p_posY + p_posX] != null 
                && m_board[m_width * p_posY + p_posX] instanceof Child 
                && ((Child)m_board[m_width * p_posY + p_posX]).isChildSleeping();
    }
    
    public synchronized boolean isLonelyPresentOnPosition(int p_x, int p_y)
    {
        
        return p_x >= 0 && p_y >= 0 && m_width * p_x + p_y < m_presents.length && m_presents[m_width * p_y + p_x] != null && !m_presents[m_width * p_y + p_x].presentHasOwner();
    }
    
    public synchronized void setPresentOwner(int p_x, int p_y)
    {
        System.out.println(p_x + " OWNER!");
        m_presents[m_width * p_y + p_x].setOwned();
    }
    
    public synchronized boolean grabThePresent(int m_posX, int m_posY, Child p_child)
    {
        if( isLonelyPresentNearby(m_posX, m_posY))
        {
            if(isLonelyPresentOnPosition(m_posX-1, m_posY  )) {System.out.println(m_posX + " PREZENT!"); setPresentOwner(m_posX-1, m_posY  ); setPosition(m_posX-1, m_posY, p_child); unsetPosition(m_posX, m_posY); p_child.forceSetPosition(m_posX-1, m_posY);}
            if(isLonelyPresentOnPosition(m_posX+1, m_posY  )) {System.out.println(m_posX + " PREZENT!"); setPresentOwner(m_posX+1, m_posY  ); setPosition(m_posX+1, m_posY, p_child);unsetPosition(m_posX, m_posY);p_child.forceSetPosition(m_posX+1, m_posY);}
            if(isLonelyPresentOnPosition(m_posX  , m_posY-1)) {System.out.println(m_posX + " PREZENT!"); setPresentOwner(m_posX,   m_posY-1); setPosition(m_posX, m_posY-1, p_child); unsetPosition(m_posX, m_posY); p_child.forceSetPosition(m_posX, m_posY-1); }
            if(isLonelyPresentOnPosition(m_posX  , m_posY+1)) {System.out.println(m_posX + " PREZENT!"); setPresentOwner(m_posX,   m_posY+1); setPosition(m_posX, m_posY+1, p_child); unsetPosition(m_posX, m_posY);p_child.forceSetPosition(m_posX, m_posY+1);}
            return true;
        }
        return false;
    }
    
    private final int       m_height;
    private final int       m_width;
    private final Entity[]  m_board;
    private final Present[] m_presents;
}
