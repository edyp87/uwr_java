package Entity;

import Santa.EntitiesPositions;
import Sprites.Sprite;
import Sprites.SpriteContainer;
import Santa.Game;
import Santa.InputHandler;
import Santa.Screen;
import java.util.Random;

public class Player extends Entity
{
    public Player(Game p_gameInstance, EntitiesPositions p_board, InputHandler p_inputHandler)
    {
        m_inputHandler = p_inputHandler;
        m_board = p_board;
        m_gameInstance = p_gameInstance;
        randomlyPutPlayer();
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        Sprite l_player = SpriteContainer.s_player;
        p_screen.applySprite(m_posX * p_tileSize, m_posY * p_tileSize, l_player);
    }
    
    @Override
    public void tick()
    {
        super.tick();
        
        if(m_inputHandler.m_up) moveUp();
        if(m_inputHandler.m_down) moveDown();
        if(m_inputHandler.m_left) moveLeft();
        if(m_inputHandler.m_right) moveRight();
        if(m_inputHandler.m_dropPresent) dropPresent();
        
        m_inputHandler.signalReceived();
    }
    private void randomlyPutPlayer()
    {
        Random l_random = new Random();
        setPosition(1 + l_random.nextInt(Game.s_gameWidth-2),
                    1 + l_random.nextInt(Game.s_gameHeight-2));
    }
    
    private void dropPresent()
    {
        m_board.dropPresent(m_posX,
                            m_posY,
                            new Present(m_posX,
                                        m_posY,
                                        m_gameInstance, m_board));
        m_inputHandler.m_dropPresent = false;
    }
    
    private InputHandler m_inputHandler;
}
