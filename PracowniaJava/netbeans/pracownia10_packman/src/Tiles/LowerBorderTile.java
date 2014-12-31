package Tiles;

import Sprites.Sprites;
import pracownia10_packman.Screen;

public class LowerBorderTile extends Tile
{
    public LowerBorderTile(int p_id)
    {
        super(p_id);
        m_tile = Sprites.m_terrain[3][1];
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        p_screen.renderSprite(p_x * m_tile.m_width, p_y * m_tile.m_height, m_tile);
    }    
}
