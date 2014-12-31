package Tiles;

import Sprites.SpriteContainer;
import Santa.Screen;

public class LowerBorderTile extends Tile
{
    public LowerBorderTile(int p_id)
    {
        super(p_id);
        m_tile = SpriteContainer.s_terrain[3][1];
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        p_screen.applySprite(p_x * m_tile.m_width, p_y * m_tile.m_height, m_tile);
    }    
}
