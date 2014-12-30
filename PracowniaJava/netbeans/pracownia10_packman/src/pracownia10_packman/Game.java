/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownia10_packman;

import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Marek
 */
public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1;
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 320;
    public static final int SCALE = 2;
    public static final String GAME_NAME = "Pacman - v0.1";
    public static final Dimension GAME_DIM = new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE);
    
    public BufferedImage m_bufferedImage = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
    public int[] m_pixels = ((DataBufferInt)m_bufferedImage.getRaster().getDataBuffer()).getData();
    Random m_random = new Random();
    
    public int m_tickCount = 0;
    
    public boolean m_gameIsRunning = false;
    
    public Game()
    {
    }
    
    private void start()
    {
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
        //++m_tickCount;
        for (int i = 0; i < m_pixels.length; ++i)
        {
            m_pixels[i] = i + m_random.nextInt();
        }
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
