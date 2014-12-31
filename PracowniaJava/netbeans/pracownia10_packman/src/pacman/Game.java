package pacman;

import Entity.Player;
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
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1;
    public static final int GAME_WIDTH = 256;
    public static final int GAME_HEIGHT = 256;
    public static final int SCALE = 3;
    public static final String GAME_NAME = "Pacman - v0.1";
    public static final Dimension GAME_DIM = new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE);
    
    public BufferedImage m_bufferedImage = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
    public int[] m_pixels = ((DataBufferInt)m_bufferedImage.getRaster().getDataBuffer()).getData();
    Random m_random = new Random();
    
    public boolean m_gameIsRunning = false;
    
    InputHandler m_input = new InputHandler(this);
    Screen m_screen;
    SpriteSheetLoader m_loader;
    Level m_level;
    Player m_player;
    
    public Game()
    {
    }
    
    public void init()
    {
        m_loader = new SpriteSheetLoader();
        m_screen = new Screen(GAME_WIDTH, GAME_HEIGHT);
        m_level = new Level(16, 16);
        m_level.renderBackground(m_screen);
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
        
        for (int i = 0; i < m_screen.m_pixels.length; ++i)
        {
            m_pixels[i] = m_screen.m_pixels[i];
        }
        m_level.renderBackground(m_screen);
        m_player.render(m_screen);
        
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
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
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
