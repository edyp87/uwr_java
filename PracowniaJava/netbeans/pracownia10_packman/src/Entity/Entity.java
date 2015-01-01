package Entity;

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
    
    public void moveUp()
    {
        if(m_posY > SpriteContainer.s_tileSize + 4)
            setPosition(m_posX, m_posY - SpriteContainer.s_tileSize);
            //m_posY -= SpriteContainer.s_tileSize;
        else
        {
            setPosition(m_posX, m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize));
            //m_posY = m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize);
        }
    }
    
    public void moveDown()
    {
        if(m_posY < m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize -SpriteContainer.s_tileSize)
            //m_posY += SpriteContainer.s_tileSize;
            setPosition(m_posX, m_posY + SpriteContainer.s_tileSize);
        else
        {
            //m_posY = SpriteContainer.s_tileSize;
            setPosition(m_posX, SpriteContainer.s_tileSize);
        }
    }
        
    public void moveLeft()
    {
        if(m_posX > SpriteContainer.s_tileSize + 4)
            //m_posX -= SpriteContainer.s_tileSize;
            setPosition(m_posX - SpriteContainer.s_tileSize, m_posY);
        else
        {
            //m_posX = m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize);
            setPosition( m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - 2*(SpriteContainer.s_tileSize), m_posY);
        }
    }
            
    public void moveRight()
    {
        if(m_posX < m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize - SpriteContainer.s_tileSize)
            //m_posX += SpriteContainer.s_tileSize;
            setPosition(m_posX + SpriteContainer.s_tileSize, m_posY);
        else
        {
            setPosition(SpriteContainer.s_tileSize, m_posY);
            //m_posX = SpriteContainer.s_tileSize;
        }
    }
    
    public void setPosition(int p_x, int p_y)
    {
        m_posX = p_x;
        m_posY = p_y;
    }
    
    public Game m_gameInstance;
    public int m_posX, m_posY;
}
