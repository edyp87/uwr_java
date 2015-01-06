package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;

public class Present extends Entity
{
    public Present(int p_x, int p_y, EntitiesPositions p_board)
    {
        m_board = p_board;
        m_posX = p_x;
        m_posY = p_y;
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        Sprite l_present = SpriteContainer.s_present;
        p_screen.applySprite(m_posX, m_posY, l_present);
    }
    
    public boolean presentHasOwner()
    {
        return m_owned;
    }
    
    public void setOwned()
    {
        m_owned = true;
    }
    
    public boolean isOwned()
    {
        return m_owned;
    }
    
    private boolean m_owned = false;
}
