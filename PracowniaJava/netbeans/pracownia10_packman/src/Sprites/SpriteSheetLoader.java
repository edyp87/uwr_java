package Sprites;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class SpriteSheetLoader
{
    public int[] m_sheetPixels;
    public int[] m_pixels;
    BufferedImage m_sheet;
    public int m_x, m_y, m_sheetWidth;
    
    public SpriteSheetLoader(BufferedImage p_sheet)
    {
        m_sheet = p_sheet; 
        
        BufferedImage l_image = new BufferedImage(m_sheet.getHeight(), m_sheet.getWidth(), BufferedImage.TYPE_INT_ARGB);
        l_image.getGraphics().drawImage(m_sheet, 0, 0, null);
        
        m_sheetPixels = ((DataBufferInt)l_image.getRaster().getDataBuffer()).getData();
        m_sheetWidth = m_sheet.getWidth();
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
