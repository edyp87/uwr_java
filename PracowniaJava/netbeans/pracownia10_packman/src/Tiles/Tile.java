package Tiles;

import Sprites.Sprite;
import Santa.Screen;

public class Tile
{
    int m_id;
    public Sprite m_tile;
    
    public static Tile[] m_tiles = new Tile[32];
    public static Tile m_blankTile = new BlankTile(0);
    public static Tile m_dotTile   = new DotTile(1);
    public static Tile m_leftUpperCornerTile   = new LeftUpperCornerTile(2);
    public static Tile m_leftLowerCornerTile   = new LeftLowerCornerTile(3);
    public static Tile m_rightUpperCornerTile   = new RightUpperCornerTile(4);
    public static Tile m_rightLowerCornerTile   = new RightLowerCornerTile(5);
    public static Tile m_lowerBorderTile = new LowerBorderTile(6);
    public static Tile m_rightBorderTile = new RightBorderTile(7);
    public static Tile m_leftBorderTile = new LeftBorderTile(8);
    public static Tile m_upperBorderTile = new UpperBorderTile(9);
    
    public Tile(int p_id)
    {
        m_id = p_id;
        m_tiles[p_id] = this;
    }
    
    public void render(int p_x, int p_y, Screen p_screen)
    {
        
    }
}
