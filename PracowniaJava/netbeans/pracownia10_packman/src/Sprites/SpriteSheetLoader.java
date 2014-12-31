package Sprites;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.imageio.ImageIO;
import pracownia10_packman.Game;

public class SpriteSheetLoader
{
    public int[] m_sheetPixels;
    public int[] m_pixels;
//    BufferedImage m_sheet;
    public int m_x, m_y, m_sheetWidth;
    
    public SpriteSheetLoader(/*BufferedImage p_sheet*/)
    {
//        m_sheet = p_sheet; 
//        
//        BufferedImage l_image = new BufferedImage(m_sheet.getHeight(), m_sheet.getWidth(), BufferedImage.TYPE_INT_ARGB);
//        l_image.getGraphics().drawImage(m_sheet, 0, 0, null);
//        
//        m_sheetPixels = ((DataBufferInt)l_image.getRaster().getDataBuffer()).getData();
//        m_sheetWidth = m_sheet.getWidth();
    }
    
    public static Sprite[][] cutTile(String p_fileName, int p_width, int p_height)
    {
        return cutTile(p_fileName, p_width, p_height, 0, 0);
    }
    
    public static Sprite[][] cutTile(String p_fileName, int p_width, int p_height, int p_xOffset, int p_yOffset)
    {
        try
        {
            System.out.println(Game.class.getResource(p_fileName));
            BufferedImage l_image = ImageIO.read(Game.class.getResource(p_fileName));
                        
            int l_xTiles = (l_image.getWidth() - p_xOffset) / p_width;
            int l_yTiles = (l_image.getHeight() - p_yOffset) / p_height;
            
            Sprite[][] l_result = new Sprite[l_xTiles][l_yTiles];
            for (int x = 0; x < l_xTiles; ++x)
            {            

                for (int y = 0; y < l_xTiles; ++y)
                {
                    l_result[x][y] = new Sprite(p_width, p_height);
                    l_image.getRGB(p_xOffset + x * p_width, p_yOffset + y * p_height, p_width, p_height, l_result[x][y].m_pixels, 0, p_width);
                }
            }
            
            return l_result;
        }
        catch(Exception e)
        {
            System.err.println(e.getStackTrace());

        }
        
        return null;
    }
    
    public void grabTile(int p_tile, int p_width, int p_height)
    {
        m_pixels = new int[p_width * p_height];
        
        int l_xTile = p_tile % 16;
        int l_yTile = p_tile / 16;
        
        for (int y  = 0; y < p_height; ++y)
        {
            for (int x = 0; x < p_width; ++x)
            {
                m_pixels[(x + (y * p_width))] = m_sheetPixels[((x + (l_xTile * p_width)) + (y + (l_yTile * p_height)) * m_sheetWidth)];
            }
        }
    }
    
}
