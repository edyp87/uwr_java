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
    
    public static void main(String[] args)
    {
        Game l_game = new Game();
        l_game.setPreferredSize(s_gameDimension);
        l_game.setMaximumSize(s_gameDimension);
        l_game.setMinimumSize(s_gameDimension);
        
        createMainFrame(l_game);
        
        l_game.start();
    }
    
    @Override
    public void run()
    {
        createAllChildThreads();
        
        while(m_gameIsRunning)
        {
            tick();
            render();
            waitInMilisec(50);
        }
    }
    
    private void start()
    {
        init();
        m_gameIsRunning = true;
        new Thread(this).start();
    }
    
    private void init()
    {
        EntitiesPositions l_board 
            = new EntitiesPositions(s_gameWidth, s_gameHeight);
        initializeEntities(l_board);
        initializePainter(l_board);
    }
    
    private void stop()
    {
        if(m_gameIsRunning)
        {
            m_gameIsRunning = false;
        }
    }
    
    private void tick()
    {
        //m_player.tick();
    }
    
    private void render()
    {
        if(getBufferStrategy() == null)
        {
            createTrippleBuffer();
            return;
        }
        
        drawCanvas(getBufferStrategy());
    }
    
    private void initializeEntities(EntitiesPositions p_board)
    {
        m_player    = new Player(p_board, new InputHandler(this));
        m_childList = new ArrayList<>();
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
    
    private void createAllChildThreads()
    {
        m_childList.stream().forEach((Child l_child) -> {
            new Thread(new ChildThread(l_child)).start();
        });
        new Thread(m_player).start();
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
    
    private static void createMainFrame(Game p_game)
    {
        JFrame l_frame = new JFrame(s_gameName);
        l_frame.setLayout(new BorderLayout());
        l_frame.add(p_game, BorderLayout.CENTER);
        l_frame.pack();
        l_frame.setVisible(true);
        l_frame.setResizable(true);
        l_frame.setLocationRelativeTo(null);
        l_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static final int       s_gameWidth        = 20;
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
