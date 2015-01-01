package Entity;

import Santa.Game;
import Santa.Screen;
import Sprites.Sprite;
import Sprites.SpriteContainer;
import java.util.Random;

public class Child extends Entity
{
    public Child(Game p_gameInstance)
    {
        m_gameInstance = p_gameInstance;
        randomlyPutChild();
    }
    
    @Override
    public void render(Screen p_screen)
    {
        Sprite l_child = SpriteContainer.s_child;
        p_screen.applySprite(m_posX, m_posY, l_child);
    }
    
    private void randomlyPutChild()
    {
        Random l_random = new Random();
        setPosition((1 + l_random.nextInt(Game.s_gameWidth-2)) * (SpriteContainer.s_tileSize),
                    (1 + l_random.nextInt(Game.s_gameHeight-2)) * (SpriteContainer.s_tileSize));
    }
}
