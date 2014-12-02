package pracownia7.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Peg extends JButton
{
    public Peg(String p_pegImageFileName, int p_row, int p_column)
    {
        m_row = p_row;
        m_column = p_column;
        m_pegImageFileName = p_pegImageFileName;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }
    
    public void changeImage(String p_pegImageFileName)
    {
        m_pegImageFileName = p_pegImageFileName;
        repaint();
    }
    
    public void changeImage()
    {
        if("peg-grey.png" == m_pegImageFileName)
        {
            m_pegImageFileName = "peg-green.png";
        }
        else
        {
            m_pegImageFileName = "peg-grey.png";
        }
        repaint();
    }
    
    public int getRow()
    {
        return m_row;
    }
    
    public int getColumn()
    {
        return m_column;
    }
        
    @Override
    protected void paintComponent(Graphics p_graphics)
    {
        try
        {
            Image l_image = ImageIO.read(this.getClass().getResource(m_pegImageFileName));
            int l_width = l_image.getWidth(null);
            int l_height = l_image.getHeight(null);
            p_graphics.drawImage(l_image, 0, 0, 64, 64, null);
        }
        catch (IOException exc)
        {
            Logger.getLogger(Peg.class.getName()).log(Level.SEVERE, null, exc);
        }
    }
    
    int m_row, m_column;
    String m_pegImageFileName;
}
