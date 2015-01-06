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
    
    public  EntitiesPositions m_board;
    public int m_posX, m_posY;
    
    public enum Moves
    {
        up, down, left, right, end;
    }
}
