package Entity;

import Sprites.Sprite;
import Sprites.SpriteContainer;
import Santa.Game;
import Santa.InputHandler;
import Santa.Screen;
import java.util.Random;

public class Player extends Entity
{
    public Player(Game p_gameInstance, InputHandler p_inputHandler)
    {
        m_inputHandler = p_inputHandler;
        m_gameInstance = p_gameInstance;
        randomlyPutPlayer();
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_player = SpriteContainer.s_player;
        p_screen.applySprite(m_playerPosX, m_playerPosY, l_player);
    }
    
    @Override
    public void tick()
    {
        super.tick();
        
        if(m_inputHandler.m_up) moveUp();
        if(m_inputHandler.m_down) moveDown();
        if(m_inputHandler.m_left) moveLeft();
        if(m_inputHandler.m_right) moveRight();
        
        m_inputHandler.signalReceived();
    }
    
    private void moveUp()
    {
        if(m_playerPosY > SpriteContainer.s_tileSize + 4)
            m_playerPosY -= SpriteContainer.s_tileSize;
    }
    
    private void moveDown()
    {
        if(m_playerPosY < m_gameInstance.s_gameHeight * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize -SpriteContainer.s_tileSize)
            m_playerPosY += SpriteContainer.s_tileSize;
    }
        
    private void moveLeft()
    {
        if(m_playerPosX > SpriteContainer.s_tileSize + 4)
            m_playerPosX -= SpriteContainer.s_tileSize;
    }
            
    private void moveRight()
    {
        if(m_playerPosX < m_gameInstance.s_gameWidth * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize - SpriteContainer.s_tileSize)
            m_playerPosX += SpriteContainer.s_tileSize;
    }
    
    private void randomlyPutPlayer()
    {
        Random l_random = new Random();
        m_playerPosX = (1 + l_random.nextInt(Game.s_gameWidth-2)) * (SpriteContainer.s_tileSize);
        m_playerPosY = (1 + l_random.nextInt(Game.s_gameWidth-2)) * (SpriteContainer.s_tileSize);
    }
    
    private InputHandler m_inputHandler;
    public Game m_gameInstance;
    public int m_playerPosX, m_playerPosY;
}
