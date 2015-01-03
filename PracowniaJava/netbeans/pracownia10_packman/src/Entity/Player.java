package Entity;

import Santa.EntitiesPositions;
import Sprites.SpriteContainer;
import Santa.Game;
import Santa.InputHandler;
import Santa.Screen;
import Threads.SynchroClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Player extends Entity implements Runnable
{
    public Player(EntitiesPositions p_board, InputHandler p_inputHandler, SynchroClass p_synchroClass)
    {
        m_inputHandler = p_inputHandler;
        m_board = p_board;
        m_synchroClass = p_synchroClass;
        randomlyPutPlayer();
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        p_screen.applySprite(SpriteContainer.tileToPix(m_posX, p_tileSize), 
                             SpriteContainer.tileToPix(m_posY, p_tileSize),
                             SpriteContainer.s_player);
    }
    
    @Override
    public void tick()
    {
       // synchronized(m_synchroClass)
        {
            m_synchroClass.handlePlayer(this, m_inputHandler);
        }
    }
    
    private void randomlyPutPlayer()
    {
        
        setPosition(randomWidth(), randomHeight());
    }
    
    public void dropPresent()
    {
        m_board.dropPresent(m_posX,
                            m_posY,
                            new Present(m_posX,
                                        m_posY,
                                        m_board));
    }
    
    public int randomWidth()
    {
        Random l_random = new Random();
        return leftBoarderSize + l_random.nextInt(Game.s_gameWidth-rightBoarderSize);
    }
    
    public int randomHeight()
    {
        Random l_random = new Random();
        return upperBorderSize + l_random.nextInt(Game.s_gameHeight-lowerBoarderSize);
    }
    
    private static final int leftBoarderSize  = 1, upperBorderSize  = 1;
    private static final int rightBoarderSize = 2, lowerBoarderSize = 2;
    private final InputHandler m_inputHandler;
    private final SynchroClass m_synchroClass;

    @Override
    public void run()
    {   
        while(true)
        {   
                tick();
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException ex) {
                }
            
        }
    }
}
