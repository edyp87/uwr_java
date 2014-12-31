package Level;

import Tiles.Tile;
import Santa.Screen;

public class Level
{
    int m_width, m_height;
    public int[] m_tiles;
    
    public Level(int p_width, int p_height)
    {
        m_width = p_width;
        m_height = p_height;
        
        m_tiles = new int[m_width * m_height];
    }
    
    public void renderBackground(Screen p_screen)
    {
        for (int y = 0; y < m_height; ++y)
        {
            for(int x = 0; x < m_width; ++x)
            {
                getTile(x, y).render(x, y, p_screen);
            }
            
        }
    }
    
    public Tile getTile(int p_x, int p_y)
    {
        if(p_x < 0 || p_y < 0 || p_x >= m_width || p_y >= m_height) return Tile.m_blankTile;
        //if(p_x == 1) return Tile.m_dotTile;
        
        //Corners
        if(p_x == 0 && p_y == 0) return Tile.m_leftUpperCornerTile;
        if(p_x == 0 && p_y == 15) return Tile.m_leftLowerCornerTile;
        if(p_x == 15 && p_y == 0) return Tile.m_rightUpperCornerTile;
        if(p_x == 15 && p_y == 15) return Tile.m_rightLowerCornerTile;
        //Walls
        if(p_x == 0) return Tile.m_leftBorderTile;
        if(p_x == 15) return Tile.m_rightBorderTile;
        if(p_y == 0) return Tile.m_upperBorderTile;
        if(p_y == 15) return Tile.m_lowerBorderTile;
        

        
        return Tile.m_tiles[m_tiles[p_x + p_y * m_width]];
    }
}
