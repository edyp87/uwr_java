package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;

public class Present extends Entity
{
    public Present(int p_x, int p_y, Game p_gameInstance, EntitiesPositions p_board)
    {
        m_gameInstance = p_gameInstance;
        m_board = p_board;
        m_posX = p_x;
        m_posY = p_y;
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_present = SpriteContainer.s_present;
        p_screen.applySprite(m_posX, m_posY, l_present);
    }
}
