package Tiles;

import Sprites.SpriteContainer;
import Santa.Screen;

public class RightBorderTile extends Tile
{
    public RightBorderTile(int p_id)
    {
        super(p_id);
        m_tile = SpriteContainer.s_terrain[1][1];
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        p_screen.applySprite(p_x, p_y, m_tile);
    }    
}
