package Tiles;

import Sprites.SpriteContainer;
import Santa.Screen;

public class LeftLowerCornerTile extends Tile
{
    public LeftLowerCornerTile(int p_id)
    {
        super(p_id);
        m_tile = SpriteContainer.s_terrain[2][2];
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        p_screen.applySprite(p_x, p_y, m_tile);
    }    
}
