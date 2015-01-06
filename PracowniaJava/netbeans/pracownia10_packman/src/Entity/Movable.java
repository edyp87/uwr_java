package Entity;

import Santa.Game;

public abstract class Movable extends Entity
{
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
    
}
