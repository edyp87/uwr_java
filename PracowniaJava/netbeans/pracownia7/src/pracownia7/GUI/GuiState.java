package pracownia7.GUI;

import pracownia7.PegSolitaire.Board;

public class GuiState
{
    public GuiState(Board p_board)
    {
        m_board = p_board;
    }
    
    public void click(int p_row, int p_column)
    {
        System.out.println("CLICK!" + p_row + " " + p_column + " " + isClicked() + " " + isMoveValid(p_row, p_column));
        if (isClicked() && isMoveValid(p_row, p_column))
        {
            System.out.println("isClicked() && isMoveValid(p_row, p_column");
            System.out.println("MOVE " + moveInDirection(p_row, p_column));
            
            unClick();
        }
        else
        {
            System.out.println("not isClicked() && isMoveValid(p_row, p_column");
            setClicked(p_row, p_column);
        }
    }
    
    private boolean isMoveValid(int p_row, int p_column)
    {
        if (p_row == m_row)
        {
            return (p_column == m_column-2 || p_column == m_column+2 );
        }
        else if(p_column == m_column)
        {
            return (p_row == m_row-2 || p_row == m_row+2);
        }
        return false;
    }
    
    private boolean moveInDirection(int p_row, int p_column)
    {
        if (p_row == m_row)
        {
            return (p_column > m_column) ? 
                m_board.moveRight(m_row, m_column) : m_board.moveLeft(m_row, m_column);
        }
        else if (p_column == m_column)
        {
            return (p_row > m_row) ? 
                m_board.moveDown(m_row, m_column) : m_board.moveUp(m_row, m_column);
        }
        return false;
    }
    
    private boolean isClicked()
    {
        return m_clicked;
    }
    
    private void unClick()
    {
        m_clicked = false;
    }
    
    private void setClicked(int p_row, int p_column)
    {
        m_clicked = true;
        m_row = p_row;
        m_column = p_column;
    }
    
    private Board m_board;
    private boolean m_clicked = false;
    private int m_row         = 0;
    private int m_column      = 0;
}
