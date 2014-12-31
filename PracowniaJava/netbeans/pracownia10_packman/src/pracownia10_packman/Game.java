package pracownia10_packman;

import Level.Level;
import Sprites.SpriteSheetLoader;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1;
    public static final int GAME_WIDTH = 400;
    public static final int GAME_HEIGHT = 220;
    public static final int SCALE = 3;
    public static final String GAME_NAME = "Pacman - v0.1";
    public static final Dimension GAME_DIM = new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE);
    
    public BufferedImage m_bufferedImage = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
    public int[] m_pixels = ((DataBufferInt)m_bufferedImage.getRaster().getDataBuffer()).getData();
    Random m_random = new Random();
    
    public boolean m_gameIsRunning = false;
    
    Screen m_screen;
    SpriteSheetLoader m_loader;
    Level m_level;
    
    public Game()
    {
    }
    
    public void init()
    {
        m_loader = new SpriteSheetLoader();
        m_screen = new Screen(GAME_WIDTH, GAME_HEIGHT);
        m_level = new Level(10, 10);
        
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
        
        for (int i = 0; i < m_screen.m_pixels.length; ++i)
        {
            m_pixels[i] = m_screen.m_pixels[i];
        }
        
        Graphics l_graphics = l_bufferStrategy.getDrawGraphics();
        l_graphics.drawImage(m_bufferedImage, 0, 0, getWidth(), getHeight(), null);
        l_graphics.dispose();
        l_bufferStrategy.show();
        
    }
    
    public void run()
    {
        while(m_gameIsRunning)
        {
            tick();
            render();
        }
    }
    
    
    public static void main(String[] args)
    {
        Game l_game = new Game();
        l_game.setPreferredSize(GAME_DIM);
        l_game.setMaximumSize(GAME_DIM);
        l_game.setMinimumSize(GAME_DIM);
        
        JFrame l_frame = new JFrame(GAME_NAME);
        l_frame.setLayout(new BorderLayout());
        l_frame.add(l_game, BorderLayout.CENTER);
        l_frame.pack();
        l_frame.setVisible(true);
        l_frame.setResizable(true);
        l_frame.setLocationRelativeTo(null);
        l_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l_game.start();
    }
}
