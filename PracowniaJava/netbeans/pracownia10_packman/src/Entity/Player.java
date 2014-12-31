package Entity;

import Sprites.Sprite;
import Sprites.SpriteContainer;
import Santa.Game;
import Santa.InputHandler;
import Santa.Screen;

public class Player extends Entity
{
    private InputHandler m_input;
    public Game m_game;
    public int m_x, m_y;
    
    public Player(Game p_game, InputHandler p_input)
    {
        m_input = p_input;
        m_game = p_game;
        
        m_x = Game.s_gameWidth * SpriteContainer.s_tileSize / 2 - SpriteContainer.s_tileSize / 2;
        m_y = Game.s_gameHeight * SpriteContainer.s_tileSize / 2 - SpriteContainer.s_tileSize / 2;
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_player = SpriteContainer.s_player;
        p_screen.renderSprite(m_x, m_y, l_player);
    }
    
    @Override
    public void tick()
    {
        super.tick();
        
        if(m_input.m_up) moveUp();
        if(m_input.m_down) moveDown();
        if(m_input.m_left) moveLeft();
        if(m_input.m_right) moveRight();
        
        m_input.signalReceived();
        
    }
    
    private void moveUp()
    {
        if(m_y > SpriteContainer.s_tileSize + 4)
           // --m_y;
            m_y -= SpriteContainer.s_tileSize;
    }
    
    private void moveDown()
    {
        if(m_y < m_game.s_gameHeight * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize -SpriteContainer.s_tileSize /2 )
           /// ++m_y;
            m_y += SpriteContainer.s_tileSize;
    }
        
    private void moveLeft()
    {
        if(m_x > SpriteContainer.s_tileSize + 4)
          //  --m_x;
            m_x -= SpriteContainer.s_tileSize;
    }
            
    private void moveRight()
    {
        if(m_x < m_game.s_gameWidth * SpriteContainer.s_tileSize - SpriteContainer.s_tileSize -SpriteContainer.s_tileSize /2 )
          //  ++m_x;
            m_x += SpriteContainer.s_tileSize;
    }
}
