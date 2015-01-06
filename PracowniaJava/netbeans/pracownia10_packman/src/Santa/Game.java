package Santa;

import Entity.Child;
import Entity.Player;
import Level.Level;
import Sprites.SpriteContainer;
import Threads.ChildThread;
import Threads.SynchroClass;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable
{
    public static void main(String[] args)
    {
        Game l_game = new Game();

        setCanvasSize(l_game);
        createMainFrame(l_game);
        
        l_game.start();
    }
    
    public Game() {}
    
    @Override
    public void run()
    {
        playMelody();
        createAllChildThreads();
        createPlayerThread();
        
        while(m_gameIsRunning)
        {
            stopIfGameHasEnded();
            render();
            waitInMilisec(50);
        }
        
        showEndingMessage();
    }
    
    private void start()
    {
        init();
        m_gameIsRunning = true;
        new Thread(this).start();
    }
    
    private void init()
    {
        m_board = new EntitiesPositions(s_gameWidth, s_gameHeight);
        m_synchroClass = new SynchroClass();
        initializeEntities(m_board);
        initializePainter(m_board);
    }
    
    private void stop()
    {
        m_gameIsRunning = false;

    }
    
    private void playMelody()
    {
        AudioInputStream l_audioIn;
        try {
            l_audioIn = AudioSystem.getAudioInputStream(Game.class.getResource(s_melodyPath));
            Clip l_clip = AudioSystem.getClip();
            l_clip.open(l_audioIn);
            l_clip.start();
        }  catch (Exception ex) {}
    }
    
    private void createAllChildThreads()
    {
        m_childList.stream().forEach((Child l_child) -> {
            new Thread(new ChildThread(l_child, m_synchroClass), "Child").start();
        });
        
    }
    
    private void createPlayerThread()
    {
        new Thread(m_player, "Player").start();
    }
    
    private void stopIfGameHasEnded()
    {
        if (m_board.victory() || m_board.lost())
            stop();
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
    
    private static void setCanvasSize(Game p_game)
    {
        p_game.setPreferredSize(s_gameDimension);
        p_game.setMaximumSize(s_gameDimension);
        p_game.setMinimumSize(s_gameDimension);
    }
    
    private void initializeEntities(EntitiesPositions p_board)
    {
        m_childList = new ArrayList<>();
        for (int i = 0; i < s_numberOfChildren; ++i)
        {
            m_childList.add(new Child(this, p_board));
        }
        
        m_player = new Player(p_board, new InputHandler(this), m_synchroClass);
    }
    
    private void initializePainter(EntitiesPositions p_board)
    {
        m_painter = new Painter(
            new Screen(s_gameWidth  * SpriteContainer.s_tileSize,
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
    
    private void showEndingMessage()
    {
        String l_message;
        if (m_board.lost())
            l_message = "Mikołaj został przyłapany przez dziecko :(";
        else
            l_message = "Mikołaj rozdał wszystkie prezenty! :)";
        JOptionPane.showMessageDialog(null, l_message, "Koniec gry", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
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
    
    public static final int       s_gameWidth        = 25;
    public static final int       s_gameHeight       = 20;
    public static final int       s_scale            = 1;
    public static final int       s_numberOfChildren = 21;
    public static final String    s_gameName         = "Santa - v0.1";
    public static final String    s_melodyPath       = "/res/jingbell.mid";
    public static final Dimension s_gameDimension    
        = new Dimension(s_gameWidth  * SpriteContainer.s_tileSize * s_scale,
                        s_gameHeight * SpriteContainer.s_tileSize * s_scale);
    
    private EntitiesPositions     m_board;
    private Player                m_player;
    private ArrayList<Child>      m_childList;
    private Painter               m_painter;
    private SynchroClass          m_synchroClass;
    
    public boolean                m_gameIsRunning = false;
}
