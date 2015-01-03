package Santa;

import Level.Level;
import static Santa.Game.s_gameHeight;
import static Santa.Game.s_gameWidth;
import Sprites.SpriteContainer;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Handle rendering particular entities on screen. 
 * Then copy screen on desired buffered image.
 * @author Marek
 */
public class Painter
{
    public Painter(Screen p_screen, EntitiesPositions p_board, Level p_background)
    {
        m_screen     = p_screen;
        m_board      = p_board;
        m_background = p_background;
        m_bufferedImage 
            = new BufferedImage(
                s_gameWidth  * SpriteContainer.s_tileSize, 
                s_gameHeight * SpriteContainer.s_tileSize,
                BufferedImage.TYPE_INT_RGB);
        m_bufferedImagePixels = ((DataBufferInt)m_bufferedImage
                                    .getRaster()
                                    .getDataBuffer())
                                        .getData();
    }
    
    public void render(BufferStrategy p_bufferStrategy, int p_width, int p_height)
    {
        renderEntitiesOnScreen();
        
        copyScreenToBufferedImage();
        
        drawImageOnBuffer(p_bufferStrategy, p_width, p_height);
    }
    
    private void renderEntitiesOnScreen()
    {
        m_background.renderBackground(m_screen);
        m_board.renderAll(m_screen, SpriteContainer.s_tileSize);
    }
    
    private void copyScreenToBufferedImage()
    {
        for (int l_pixelNumber = 0; l_pixelNumber < m_screen.getNumberOfPixels(); ++l_pixelNumber)
        {
            m_bufferedImagePixels[l_pixelNumber] = m_screen.getPixel(l_pixelNumber);
        }
    }
    
    private void drawImageOnBuffer(BufferStrategy p_bufferStrategy, int p_width, int p_height)
    {
        Graphics l_graphics = p_bufferStrategy.getDrawGraphics();
        l_graphics.drawImage(m_bufferedImage, 0, 0, p_width, p_height, null);
        l_graphics.dispose();
        p_bufferStrategy.show();
    }
    
    private final Screen            m_screen;
    private final EntitiesPositions m_board;
    private final Level             m_background;
    public  BufferedImage           m_bufferedImage;
    private final int[]             m_bufferedImagePixels;
}
