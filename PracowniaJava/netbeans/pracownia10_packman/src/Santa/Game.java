package Santa;

import Entity.Child;
import Entity.Player;
import Level.Level;
import Sprites.SpriteContainer;
import Sprites.SpriteLoader;
import Threads.ChildThread;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{    
    public Game()
    {
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
    
    public void init()
    {
        m_loader = new SpriteLoader();
        m_screen = new Screen(s_gameWidth * SpriteContainer.s_tileSize, s_gameHeight * SpriteContainer.s_tileSize);
        m_level  = new Level(s_gameWidth, s_gameHeight);
        m_board  = new EntitiesPositions(s_gameWidth, s_gameHeight);
        m_player = new Player(this, m_board, m_input);
        //m_child  = new Child(this);
        m_childList = new ArrayList<Child>();
        for (int i = 0; i < 12; ++i)
        {
            m_childList.add(new Child(this, m_board));
        }
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
    
    public synchronized void render()
    {
        
        BufferStrategy l_bufferStrategy = getBufferStrategy();
        if(l_bufferStrategy == null)
        {
            createTrippleBuffer();
            return;
        }
        
        drawCanvas(l_bufferStrategy);
    }
    
    @Override
    public void run()
    {
        new Thread(new ChildThread(m_childList.get(0))).start();
        for(Child l_child : m_childList)
        {
            new Thread(new ChildThread(l_child)).start();
        }
        
        while(m_gameIsRunning)
        {
            tick();
            render();
            waitInMilisec(50);
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
    
    private void createTrippleBuffer()
    {
        int l_trippleBuffer = 3;
        createBufferStrategy(l_trippleBuffer);
        requestFocus();
    }
    
    private void drawCanvas(BufferStrategy p_bufferStrategy)
    {
        m_level.renderBackground(m_screen);
        m_player.render(m_screen);
        for(Child l_child : m_childList)
        {
            l_child.render(m_screen);
        }
        
        for (int i = 0; i < m_screen.getNumberOfPixels(); ++i)
        {
            m_bufferedImagePixels[i] = m_screen.getPixel(i);
        }
        
        Graphics l_graphics = p_bufferStrategy.getDrawGraphics();
        l_graphics.drawImage(m_bufferedImage, 0, 0, getWidth(), getHeight(), null);
        l_graphics.dispose();
        p_bufferStrategy.show();
    }
    
    private void waitInMilisec(int p_milisec)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(p_milisec);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Game.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static final int       s_gameWidth        = 25;
    public static final int       s_gameHeight       = 15;
    public static final int       s_scale            = 1;
    public static final String    s_gameName         = "Santa - v0.1";
    public static final Dimension s_gameDimension    = new Dimension(s_gameWidth * SpriteContainer.s_tileSize * s_scale, s_gameHeight * SpriteContainer.s_tileSize * s_scale);
    
    public BufferedImage m_bufferedImage;
    private final int[] m_bufferedImagePixels;
    
    public boolean m_gameIsRunning = false;
    
    InputHandler      m_input = new InputHandler(this);
    Screen            m_screen;
    SpriteLoader m_loader;
    Level             m_level;
    Player            m_player;
    Child             m_child;
    ArrayList<Child>  m_childList;
    EntitiesPositions m_board;
}
