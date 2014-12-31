/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownia10_packman;

import Sprites.SpriteSheetLoader;
import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Marek
 */
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
//    
//    public int m_tickCount = 0;
    
    public boolean m_gameIsRunning = false;
    
    Screen m_screen;
    SpriteSheetLoader m_loader;
    
    public Game()
    {
    }
    
    public void init()
    {
        BufferedImage l_sheet = null;
        try
        {
            System.out.println(Game.class.getResource("/res/terrain.png"));
            l_sheet = ImageIO.read(Game.class.getResource("/res/terrain.png"));
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        m_loader = new SpriteSheetLoader(l_sheet);
        m_screen = new Screen(GAME_WIDTH, GAME_HEIGHT, m_loader);
        
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
//        ++m_tickCount;
        int l_xCenter = GAME_WIDTH / 2 - 8;
        int l_yCenter = GAME_HEIGHT / 2 - 8;
        m_screen.render(l_xCenter, l_yCenter, 0, 16, 16);
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
