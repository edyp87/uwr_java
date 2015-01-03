package Entity;

import Santa.EntitiesPositions;
import Sprites.SpriteContainer;
import Santa.Game;
import Santa.InputHandler;
import Santa.Screen;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player extends Entity implements Runnable
{
    public Player(EntitiesPositions p_board, InputHandler p_inputHandler)
    {
        m_inputHandler = p_inputHandler;
        m_board = p_board;
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
        movePlayer();   
    }
    
    private void randomlyPutPlayer()
    {
        
        setPosition(randomWidth(), randomHeight());
    }
    
    private void movePlayer()
    {
        if(m_inputHandler.m_up)          moveUp();
        if(m_inputHandler.m_down)        moveDown();
        if(m_inputHandler.m_left)        moveLeft();
        if(m_inputHandler.m_right)       moveRight();
        if(m_inputHandler.m_dropPresent) dropPresent();
        m_inputHandler.signalReceived();
    }
    
    private void dropPresent()
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

    @Override
    public void run()
    {
        while(true)
        {
            tick();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
