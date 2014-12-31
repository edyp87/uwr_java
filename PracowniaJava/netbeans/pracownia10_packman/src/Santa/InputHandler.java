package Santa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener
{
    public boolean m_up = false, m_down = false, m_right = false, m_left = false;
    
    public InputHandler(Game p_game)
    {
        p_game.addKeyListener(this);
    }
    
    public void toggle(KeyEvent p_event, boolean p_pressed)
    {
        int l_keyCode = p_event.getKeyCode();
        
        if(l_keyCode == KeyEvent.VK_UP) m_up = p_pressed;
        if(l_keyCode == KeyEvent.VK_DOWN) m_down = p_pressed;
        if(l_keyCode == KeyEvent.VK_RIGHT) m_right = p_pressed;
        if(l_keyCode == KeyEvent.VK_LEFT) m_left = p_pressed;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        toggle(e, false);
    }
    
}
