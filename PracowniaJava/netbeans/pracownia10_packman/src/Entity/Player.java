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
        m_gameInstance = p_gameInstance;
        randomlyPutPlayer();
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_player = SpriteContainer.s_player;
        p_screen.applySprite(m_posX, m_posY, l_player);
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
    private void randomlyPutPlayer()
    {
        Random l_random = new Random();
        setPosition((1 + l_random.nextInt(Game.s_gameWidth-2))  * (SpriteContainer.s_tileSize),
                    (1 + l_random.nextInt(Game.s_gameHeight-2)) * (SpriteContainer.s_tileSize));
        System.out.println(m_posX / SpriteContainer.s_tileSize + " " + m_posY / SpriteContainer.s_tileSize);
    }
    
    private InputHandler m_inputHandler;
}
