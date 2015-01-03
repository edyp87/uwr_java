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
    
    public void renderAll(Screen p_screen, int p_tileSize)
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
    
    public int getSantaPosition()
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

    public boolean isNeighboringChildSleeping(int p_posX, int p_posY)
    {
        return isChildSleeping(p_posX-1, p_posY  )
            || isChildSleeping(p_posX+1, p_posY  )
            || isChildSleeping(p_posX,   p_posY-1)
            || isChildSleeping(p_posX,   p_posY+1);
        
    }
    
    private boolean isChildSleeping(int p_posX, int p_posY)
    {
        return m_width * p_posY + p_posX < m_board.length
                && m_board[m_width * p_posY + p_posX] != null 
                && m_board[m_width * p_posY + p_posX] instanceof Child 
                && ((Child)m_board[m_width * p_posY + p_posX]).isChildSleeping();
    }
    
    public boolean isPresentOnPosition(int p_x, int p_y)
    {
        return m_presents[m_width * p_y + p_x] != null;
    }
    
    private final int       m_height;
    private final int       m_width;
    private final Entity[]  m_board;
    private final Present[] m_presents;
}
