package Santa;

import Entity.Child;
import Entity.Player;
import Level.Level;
import Sprites.SpriteContainer;
import Threads.ChildThread;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{    
    public Game() {}
    
    public void init()
    {
        EntitiesPositions l_board 
            = new EntitiesPositions(s_gameWidth, s_gameHeight);
        initializeEntities(l_board);
        initializePainter(l_board);
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
        if(getBufferStrategy() == null)
        {
            createTrippleBuffer();
            return;
        }
        
        drawCanvas(getBufferStrategy());
    }
    
    @Override
    public void run()
    {
        for (Child l_child : m_childList)
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
    
    private void initializeEntities(EntitiesPositions p_board)
    {
        m_player    = new Player(this, p_board, new InputHandler(this));
        m_childList = new ArrayList<Child>();
        for (int i = 0; i < s_numberOfChildren; ++i)
        {
            m_childList.add(new Child(this, p_board));
        }
    }
    
    private void initializePainter(EntitiesPositions p_board)
    {
        m_painter = new Painter(
        new Screen(s_gameWidth * SpriteContainer.s_tileSize,
                   s_gameHeight * SpriteContainer.s_tileSize),
                   p_board,
                   new Level(s_gameWidth, s_gameHeight));
    }
    
    private void createTrippleBuffer()
    {
        int l_trippleBuffer = 3;
        createBufferStrategy(l_trippleBuffer);
        requestFocus();
    }
    
    private void drawCanvas(BufferStrategy p_bufferStrategy)
    {
        m_painter.render(p_bufferStrategy, getWidth(), getHeight());
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

    public static final int       s_gameWidth        = 25;
    public static final int       s_gameHeight       = 15;
    public static final int       s_scale            = 1;
    public static final int       s_numberOfChildren = 12;
    public static final String    s_gameName         = "Santa - v0.1";
    public static final Dimension s_gameDimension    
        = new Dimension(s_gameWidth  * SpriteContainer.s_tileSize * s_scale,
                        s_gameHeight * SpriteContainer.s_tileSize * s_scale);
    
    
    private Player                m_player;
    private ArrayList<Child>      m_childList;
    private Painter               m_painter;
    
    public boolean                m_gameIsRunning = false;
}
