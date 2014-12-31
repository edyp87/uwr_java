package Santa;

import Entity.Player;
import Level.Level;
import Sprites.SpriteContainer;
import Sprites.SpriteLoader;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{    
    public Game()
    {
        m_bufferedImage 
            = new BufferedImage(
                s_gameWidth * SpriteContainer.s_tileSize, 
                s_gameHeight * SpriteContainer.s_tileSize,
                BufferedImage.TYPE_INT_RGB);
        m_bufferedImagePixels = ((DataBufferInt)m_bufferedImage
                                    .getRaster()
                                    .getDataBuffer())
                                        .getData();
    }
    
    public void init()
    {
        m_loader = new SpriteLoader();
        m_screen = new Screen(s_gameWidth * SpriteContainer.s_tileSize, s_gameHeight * SpriteContainer.s_tileSize);
        m_level  = new Level(s_gameWidth, s_gameHeight);
        m_player = new Player(this, m_input);
    }
    
    private void start()
    {
        init();
        m_gameIsRunning = true;
        new Thread(this).start();
    }
    
    public void stop()
    {
        if(m_gameIsRunning)
        {
            m_gameIsRunning = false;
        }
    }
    
    public void tick()
    {
        m_player.tick();
    }
    
    public void render()
    {
        BufferStrategy l_bufferStrategy = getBufferStrategy();
        if(l_bufferStrategy == null)
        {
            createBufferStrategy(3);
            requestFocus();
            return;
        }
        
        m_level.renderBackground(m_screen);
        m_player.render(m_screen);
        
        for (int i = 0; i < m_screen.m_pixels.length; ++i)
        {
            m_bufferedImagePixels[i] = m_screen.m_pixels[i];
        }
        
        Graphics l_graphics = l_bufferStrategy.getDrawGraphics();
        l_graphics.drawImage(m_bufferedImage, 0, 0, getWidth(), getHeight(), null);
        l_graphics.dispose();
        l_bufferStrategy.show();
    }
    
    @Override
    public void run()
    {
        while(m_gameIsRunning)
        {
            tick();
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
            render();
        }
    }
    
    public static void main(String[] args)
    {
        Game l_game = new Game();
        l_game.setPreferredSize(s_gameDimension);
        l_game.setMaximumSize(s_gameDimension);
        l_game.setMinimumSize(s_gameDimension);
        
        JFrame l_frame = new JFrame(s_gameName);
        l_frame.setLayout(new BorderLayout());
        l_frame.add(l_game, BorderLayout.CENTER);
        l_frame.pack();
        l_frame.setVisible(true);
        l_frame.setResizable(true);
        l_frame.setLocationRelativeTo(null);
        l_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l_game.start();
    }
    
    public static final int       s_gameWidth        = 40;
    public static final int       s_gameHeight       = 30;
    public static final int       s_scale            = 2;
    public static final String    s_gameName         = "Santa - v0.1";
    public static final Dimension s_gameDimension    = new Dimension(s_gameWidth * SpriteContainer.s_tileSize * s_scale, s_gameHeight * SpriteContainer.s_tileSize * s_scale);
    
    public BufferedImage m_bufferedImage;
    private int[] m_bufferedImagePixels;
    
    public boolean m_gameIsRunning = false;
    
    InputHandler      m_input = new InputHandler(this);
    Screen            m_screen;
    SpriteLoader m_loader;
    Level             m_level;
    Player            m_player;
}
