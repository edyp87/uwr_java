package pracownia7.GUI;

import pracownia7.PegSolitaire.IBoard;

public class GuiState
{
    public GuiState(IBoard p_board)
    {
        m_board = p_board;
    }
    
    public boolean click(int p_row, int p_column)
    {
        System.out.println("CLICK!" + p_row + " " + p_column + " " + isClicked() + " " + isMoveValid(p_row, p_column));
        if (isClicked() && isMoveValid(p_row, p_column))
        {
            unClick();
            if(!moveInDirection(p_row, p_column))
            {
                setClicked(p_row, p_column);
            }
            else
            {
                ++m_moves;
            }
            System.out.println("MOVES: " + m_moves);
            return true;
        }
        else
        {
            setClicked(p_row, p_column);
            return false;
        }
    }
    
    public int getClickedRow()
    {
        return m_row;
    }
    
    public int getClickedColumn()
    {
        return m_column;
    }
    
    public int getMoves()
    {
        return m_moves;
    }
    
    public void resetBoard()
    {
        m_board.resetBoard();
        m_clicked = false;
        m_gameOver = false;
        m_row         = 0;
        m_column      = 0;
        m_moves       = 0;
    }
    
        public void resetBoard(IBoard p_board)
    {
        m_board = p_board;
        m_clicked = false;
        m_gameOver = false;
        m_row         = 0;
        m_column      = 0;
        m_moves       = 0;
    }
    
    public boolean isAnyMovePossible()
    {
        if(m_board.isAnyMovePossible())
        {
            m_gameOver = false;
            return true;
        }
        else
        {
            m_gameOver = true;
            return false;
        }
    }
    
    public boolean isGameOver()
    {
        return m_gameOver;
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
    
    public boolean isClicked()
    {
        return m_clicked;
    }
    
    boolean isClicked(int p_row, int p_column)
    {
       // System.out.println("IS CLICKED! " + (isClicked() && p_row == m_row && p_column == m_column));
        return isClicked() && p_row == m_row && p_column == m_column;
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
    
    private IBoard m_board;
    private boolean m_clicked  = false;
    private boolean m_gameOver = false;
    private int m_row          = 0;
    private int m_column       = 0;
    private int m_moves        = 0;
}
