package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.SpriteContainer;

public abstract class Entity
{
    public Entity()
    {
        
    }
    
    public void render(Screen p_screen)
    {
        
    }
    
    public void tick()
    {
        
    }
    
    public boolean moveUp()
    {
        if(m_posY > SpriteContainer.s_tileSize + 4)
            return setPosition(m_posX, m_posY - SpriteContainer.s_tileSize);
            //m_posY -= SpriteContainer.s_tileSize;
        else
        {
            return setPosition(m_posX, m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize));
            //m_posY = m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize);
        }
    }
    
    public boolean moveDown()
    {
        if(m_posY < m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize -SpriteContainer.s_tileSize)
            //m_posY += SpriteContainer.s_tileSize;
            return setPosition(m_posX, m_posY + SpriteContainer.s_tileSize);
        else
        {
            //m_posY = SpriteContainer.s_tileSize;
            return setPosition(m_posX, SpriteContainer.s_tileSize);
        }
    }
        
    public boolean moveLeft()
    {
        if(m_posX > SpriteContainer.s_tileSize + 4)
            //m_posX -= SpriteContainer.s_tileSize;
            return setPosition(m_posX - SpriteContainer.s_tileSize, m_posY);
        else
        {
            //m_posX = m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize);
            return setPosition( m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize), m_posY);
        }
    }
            
    public boolean moveRight()
    {
        if(m_posX < m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize - SpriteContainer.s_tileSize)
            //m_posX += SpriteContainer.s_tileSize;
            return setPosition(m_posX + SpriteContainer.s_tileSize, m_posY);
        else
        {
            return setPosition(SpriteContainer.s_tileSize, m_posY);
            //m_posX = SpriteContainer.s_tileSize;
        }
    }
    
    public boolean setPosition(int p_x, int p_y)
    {
        if(m_board.setPosition(p_x / SpriteContainer.s_tileSize, p_y / SpriteContainer.s_tileSize))
        {
            m_board.unsetPosition(m_posX / SpriteContainer.s_tileSize, m_posY / SpriteContainer.s_tileSize);
            m_posX = p_x;
            m_posY = p_y;   
            return true;
        }
        return false;
    }
    
    public Game m_gameInstance;
    protected EntitiesPositions m_board;
    public int m_posX, m_posY;
}
