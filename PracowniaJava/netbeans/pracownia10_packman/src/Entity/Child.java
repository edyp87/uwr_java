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
        m_gameInstance = p_gameInstance;
        m_board = p_board;
        randomlyPutChild();
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_child;
        if(m_childIsSleeping)
            l_child = SpriteContainer.s_childSleeping;
        else
            l_child = SpriteContainer.s_child;
        p_screen.applySprite(m_posX, m_posY, l_child);
    }
    
    private void randomlyPutChild()
    {
        Random l_random = new Random();
        setPosition((1 + l_random.nextInt(Game.s_gameWidth-2)) * (SpriteContainer.s_tileSize),
                    (1 + l_random.nextInt(Game.s_gameHeight-2)) * (SpriteContainer.s_tileSize));
    }
    
    public void napTime()
    {
        m_childIsSleeping = true;
    }
    
    public void playTime()
    {
        m_childIsSleeping = false;
    }
    
    public int iSeeSanta()
    {
        return m_board.isSantaInRadius(m_posX, m_posX);
    }
    
    private boolean m_childIsSleeping = false;
}
