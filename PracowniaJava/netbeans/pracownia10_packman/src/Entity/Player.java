package Entity;

import Sprites.Sprite;
import Sprites.Sprites;
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
        
        m_x = Game.GAME_WIDTH / 2 - 8;
        m_y = Game.GAME_HEIGHT / 2 - 8;
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_player = Sprites.m_player;
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
        
    }
    
    private void moveUp()
    {
        if(m_y > 4)
            --m_y;
    }
    
    private void moveDown()
    {
        if(m_y < m_game.GAME_HEIGHT - 4 - 16)
            ++m_y;
    }
        
    private void moveLeft()
    {
        if(m_x > 4)
            --m_x;
    }
            
    private void moveRight()
    {
        if(m_x < m_game.GAME_WIDTH - 5 - 16)
            ++m_x;
    }
}
