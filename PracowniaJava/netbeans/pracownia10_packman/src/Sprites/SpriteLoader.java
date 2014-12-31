package Sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import Santa.Game;

public class SpriteLoader
{
    public int[] m_sheetPixels;
    public int[] m_pixels;
    public int m_x, m_y, m_sheetWidth;
    
    public SpriteLoader()
    {
    }
    
    public static Sprite[][] cutTile(String p_fileName, int p_tileWidth, int p_tileHeight)
    {
        return cutTile(p_fileName, p_tileWidth, p_tileHeight, 0, 0);
    }
    
    public static Sprite[][] cutTile(String p_fileName, int p_tileWidth, int p_tileHeight, int p_xOffset, int p_yOffset)
    {
        try
        {
            BufferedImage l_image = ImageIO.read(Game.class.getResource(p_fileName));
                        
            int l_numOfTilesInRow    = (l_image.getWidth()  - p_xOffset) / p_tileWidth;
            int l_numOfTilesInColumn = (l_image.getHeight() - p_yOffset) / p_tileHeight;
            
            Sprite[][] l_sprites = new Sprite[l_numOfTilesInRow][l_numOfTilesInColumn];
            for (int x = 0; x < l_numOfTilesInRow; ++x)
            {
                for (int y = 0; y < l_numOfTilesInColumn; ++y)
                {
                    l_sprites[x][y] = new Sprite(p_tileWidth, p_tileHeight);
                    l_image.getRGB(
                        p_xOffset + x * p_tileWidth,
                        p_yOffset + y * p_tileHeight,
                        p_tileWidth,
                        p_tileHeight,
                        l_sprites[x][y].m_pixels, 0, p_tileWidth);
                }
            }
            return l_sprites;
        }
        catch(Exception e)
        {
            System.err.println(e.getStackTrace());
        }
        return null;
    }
}
