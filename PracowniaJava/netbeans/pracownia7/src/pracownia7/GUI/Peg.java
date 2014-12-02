package pracownia7.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Peg extends JButton
{
    public Peg(String p_pegImageFileName)
    {
        m_pegImageFileName = p_pegImageFileName;
         this.setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
    }
    
    public void changeImage(String p_pegImageFileName)
    {
        m_pegImageFileName = p_pegImageFileName;
        repaint();
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
    
    String m_pegImageFileName;
}
