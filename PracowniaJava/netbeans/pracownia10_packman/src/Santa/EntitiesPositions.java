package Santa;

import Entity.Entity;
import Entity.Present;

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
        if(m_presents[m_width * p_y + p_x] == null)
        {
            m_presents[m_width * p_y + p_x] = p_entity;
            return true;
        }
        return false;
    }
    
    public void renderAll(Screen p_screen)
    {
        for(Present p_entity : m_presents)
        {
            if(p_entity != null)
            {
                p_entity.render(p_screen);
            }
        }
                
        for(Entity p_entity : m_board)
        {
            if(p_entity != null)
            {
                p_entity.render(p_screen);
            }
        }
    }
    
    public synchronized void unsetPosition(int p_x, int p_y)
    {
        m_board[m_width * p_y + p_x] = null;
    }
    
    
    
    private int m_width, m_height;
    private Entity[] m_board;
    private Present[] m_presents;
}