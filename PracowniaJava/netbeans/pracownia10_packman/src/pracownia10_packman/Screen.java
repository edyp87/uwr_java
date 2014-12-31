package pracownia10_packman;

import Sprites.Sprite;
import Sprites.SpriteSheetLoader;

public class Screen
{
    private int m_weight, m_height;
    public int[] m_pixels;
    private int m_xOffset = 0, m_yOffset =  0;
    
    public Screen(int p_weight, int p_height)
    {
        m_weight = p_weight;
        m_height = p_height;
        
        m_pixels = new int[m_weight * m_height];
    }
    
    public void renderSprite(int p_xPos, int p_yPos, Sprite p_sprite)
    {
        int l_height = p_sprite.m_height;
        int l_width = p_sprite.m_width;
        
        p_xPos -= m_xOffset;
        p_yPos -= m_yOffset;
        
        for (int y = 0; y < l_height; ++y)
        {
            if(p_yPos + y < 0 || p_yPos + y >= m_height) continue;
            for (int x = 0; x < l_width; ++x)
            {
                if(p_xPos + x < 0 || p_xPos + x >= m_weight) continue;
                
                int l_col = p_sprite.m_pixels[x + (y * l_height)];
                if(l_col != -65281 && l_col < 0) m_pixels[(x + p_xPos) + (y + p_yPos) * m_weight] = l_col;
            }
        }
    }
}
