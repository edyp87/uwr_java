package Santa;

import Sprites.Sprite;

public class Screen
{
    
    public Screen(int p_pixWidth, int p_pixHeight)
    {
        m_pixWidth  = p_pixWidth;
        m_pixHeight = p_pixHeight;
        
        m_pixelMap = new int[m_pixWidth * m_pixHeight];
    }
    
    public void applySprite(int p_spritePosX, int p_spritePosY, Sprite p_sprite)
    {
        int l_height       = p_sprite.m_height;
        int l_width        = p_sprite.m_width;
        int l_spritePosX   = p_spritePosX;
        int l_spritePosY   = p_spritePosY;
        
        for (int l_pixPosY = 0; l_pixPosY < l_height; ++l_pixPosY)
        {
            if (pixelIsOutsideColumn(l_spritePosY, l_pixPosY)) continue;
            
            for (int l_pixPosX = 0; l_pixPosX < l_width; ++l_pixPosX)
            {
                if(pixelIsOutsideRow(l_spritePosX, l_pixPosX)) continue;
                putPixel(l_spritePosX, l_spritePosY, l_pixPosX, l_pixPosY, p_sprite);
            }
        }
    }
    
    public int getPixel(int p_pixelPos)
    {
        return m_pixelMap[p_pixelPos];
    }
    
    public int getNumberOfPixels()
    {
        return m_pixelMap.length;
    }
    
    private boolean pixelIsOutsideColumn(int p_spritePosY, int p_pixPosY)
    {
        return p_spritePosY + p_pixPosY < 0 || p_spritePosY + p_pixPosY >= m_pixHeight;
    }
    
    private boolean pixelIsOutsideRow(int p_spritePosX, int p_pixPosX)
    {
        return p_spritePosX + p_pixPosX < 0 || p_spritePosX + p_pixPosX >= m_pixWidth;
    }

    private void putPixel(int p_spritePosX, int p_spritePosY, int p_pixPosX, int p_pixPosY, Sprite p_sprite)
    {
        int l_pixelValue = p_sprite.m_pixels[p_pixPosX + (p_pixPosY * p_sprite.m_height)];
        if (l_pixelValue < 0) // for transparency 
        {
            m_pixelMap[(p_pixPosX + p_spritePosX) + (p_pixPosY + p_spritePosY) * m_pixWidth] = l_pixelValue;     
        }
    }
    
    private int[]     m_pixelMap;
    final private int m_pixHeight;
    final private int m_pixWidth;
}
