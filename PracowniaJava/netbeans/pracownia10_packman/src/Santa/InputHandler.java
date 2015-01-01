package Santa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener
{
    public InputHandler(Game p_game)
    {
        p_game.addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        toggleWsad(e, true);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //toggle(e, false);
    }
    
    public void signalReceived()
    {
         m_up = m_down = m_right = m_left = false;
    }
    
    private void toggleWsad(KeyEvent p_event, boolean p_pressed)
    {
        int l_keyCode = p_event.getKeyChar();

        if(l_keyCode == 'w') m_up          = p_pressed;
        if(l_keyCode == 's') m_down        = p_pressed;
        if(l_keyCode == 'd') m_right       = p_pressed;
        if(l_keyCode == 'a') m_left        = p_pressed;
        if(l_keyCode == 'f') m_dropPresent = p_pressed;
    }
    
    public boolean m_up = false, m_down = false, m_right = false, m_left = false, m_dropPresent = false;
}
