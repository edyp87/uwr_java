package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;

public abstract class Entity
{
    public Entity()
    {
        
    }
    
    public void render(Screen p_screen, int p_tileSize)
    {
        
    }
    
    public void tick()
    {
        
    }
    
    public boolean moveUp()
    {
        if(m_posY > 1)
            return setPosition(m_posX, m_posY - 1);
        else
        {
            return setPosition(m_posX, Game.s_gameHeight - 2);
        }
    }
    
    public boolean moveDown()
    {
        if(m_posY < Game.s_gameHeight - 2)
            return setPosition(m_posX, m_posY + 1);
        else
        {
            return setPosition(m_posX, 1);
        }
    }
        
    public boolean moveLeft()
    {
        if(m_posX > 1)
            return setPosition(m_posX - 1, m_posY);
        else
        {
            return setPosition( Game.s_gameWidth - 2, m_posY);
        }
    }
            
    public boolean moveRight()
    {
        if(m_posX < Game.s_gameWidth - 2)
            return setPosition(m_posX + 1, m_posY);
        else
        {
            return setPosition(1, m_posY);
        }
    }
    
    public boolean setPosition(int p_x, int p_y)
    {
        if(m_board.setPosition(p_x, p_y, this) && !m_board.isLonelyPresentOnPosition(p_x, p_y))
        {
            m_board.unsetPosition(m_posX, m_posY);
            m_posX = p_x;
            m_posY = p_y;   
            return true;
        }
        return false;
    }
    
    public void forceSetPosition(int p_x, int p_y)
    {
            m_posX = p_x;
            m_posY = p_y;  
    }
    
    protected EntitiesPositions m_board;
    public int m_posX, m_posY;
}
