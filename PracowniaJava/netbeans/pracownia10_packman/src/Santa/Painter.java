package Santa;

import Level.Level;


public class Painter
{
    public Painter(EntitiesPositions p_board, Level p_background)
    {
        m_board      = p_board;
        m_background = p_background;
    }
    
    public void render(Screen p_screen)
    {
        m_background.renderBackground(p_screen);
        m_board.renderAll(p_screen);
    }
    
    private EntitiesPositions m_board;
    private Level             m_background;
}
