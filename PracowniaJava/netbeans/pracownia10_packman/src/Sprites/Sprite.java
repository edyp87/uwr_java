package Sprites;

public class Sprite
{
    public int m_width, m_height;
    public int[] m_pixels;
    
    public Sprite(int p_weight, int p_height)
    {
        m_width = p_weight;
        m_height = p_height;
        
        m_pixels = new int[m_width * m_height];
    }
    
//    public void color(int p_colour)
//    {
//        for (int i = 0; i < m_pixels.length; ++i)
//        {
//            m_pixels[i] = p_colour;
//        }
//    }
    
}
