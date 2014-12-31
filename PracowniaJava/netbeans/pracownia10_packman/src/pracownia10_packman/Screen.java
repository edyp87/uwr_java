package pracownia10_packman;

import Sprites.SpriteSheetLoader;

public class Screen
{
    private int m_weight, m_height;
    public int[] m_pixels;
    private SpriteSheetLoader m_loader;
    private int m_xOffset, m_yOffset;
    
    public Screen(int p_weight, int p_height, SpriteSheetLoader p_loader)
    {
        m_weight = p_weight;
        m_height = p_height;
        m_loader = p_loader;
        
        m_pixels = new int[m_weight * m_height];
    }
    
    public void render(int p_xPos, int p_yPos, int p_tile, int p_width, int p_height)
    {
        m_loader.grabTile(p_tile, p_width, p_height);
        
        p_xPos -= m_xOffset;
        p_yPos -= m_yOffset;
        
        for (int y = 0; y < p_height; ++y)
        {
            if(p_yPos + y < 0 || p_yPos + y >= m_height) continue;
            for (int x = 0; x < p_width; ++x)
            {
                if(p_xPos + x < 0 || p_xPos + x >= m_weight) continue;
                
                int l_col = m_loader.m_pixels[x + (y * p_height)];
                if(l_col != -65281) m_pixels[(x + p_xPos) + (y + p_yPos) * m_weight] = l_col;
            }
        }
    }
}
