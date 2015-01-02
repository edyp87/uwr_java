package Entity;

import Santa.EntitiesPositions;
import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;
import java.util.Random;

public class Child extends Entity
{
    public Child(Game p_gameInstance, EntitiesPositions p_board)
    {
        m_board = p_board;
        randomlyPutChild();
    }
    
    @Override
    public void render(Screen p_screen, int p_tileSize)
    {
        Sprite l_child;
        if(m_childIsSleeping)
            l_child = SpriteContainer.s_childSleeping;
        else
            l_child = SpriteContainer.s_child;
        p_screen.applySprite(m_posX * p_tileSize, m_posY * p_tileSize, l_child);
    }
    
    private void randomlyPutChild()
    {
        Random l_random = new Random();
        setPosition(1 + l_random.nextInt(Game.s_gameWidth-2),
                    1 + l_random.nextInt(Game.s_gameHeight-2));
    }
    
    public void napTime()
    {
        m_childIsSleeping = true;
    }
    
    public void playTime()
    {
        m_childIsSleeping = false;
    }
    
    private boolean m_childIsSleeping = false;
}
