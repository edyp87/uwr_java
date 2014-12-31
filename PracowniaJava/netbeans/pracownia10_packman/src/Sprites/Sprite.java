/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprites;

/**
 *
 * @author Marek
 */
public class Sprite
{
    public int m_weight, m_height;
    public int[] m_pixels;
    
    public Sprite(int p_weight, int p_height)
    {
        m_weight = p_weight;
        m_height = p_height;
        
        m_pixels = new int[m_weight * m_height];
    }
    
    public void color(int p_colour)
    {
        for (int i = 0; i < m_pixels.length; ++i)
        {
            m_pixels[i] = p_colour;
        }
    }
    
}
