package pracownia7.PegSolitaire;

import java.util.ArrayList;

public class Board
{
    public Board()
    {
        initBoardWithDefaultSetting();
        rememberMove();
    }
    
    public void printBoard()
    {
        for (int l_row = 0; l_row < c_rows; ++l_row)
        {
            for (int l_column = 0; l_column < c_columns; ++l_column)
            {
                System.out.print(m_board[l_row][l_column] + " ");
            }
            System.out.println();
        }
    }
    
    public Integer[][] getBoard()
    {
        return m_board;
    }
    
    private void initBoardWithDefaultSetting()
    {
        for (int l_row = 0; l_row < c_rows; ++l_row)
        {
            for (int l_column = 0; l_column < c_columns; ++l_column)
            {
                initPeg(l_row, l_column);
            }
        }
    }
    
    private void initPeg(int l_row, int l_column)
    {
        m_board[l_row][l_column] = 0;
        if (isPegPositionOnBoard(l_row, l_column) && !isPositionCenter(l_row, l_column))
        {
            m_board[l_row][l_column] = 1;
        }
    }
    
    public boolean moveLeft(int l_row, int l_column)
    {
        if (isPegPositionOnBoard(l_row, l_column-2)
         && isPegOnThisPosition(l_row, l_column  )
         && isPegOnThisPosition(l_row, l_column-1)
        && !isPegOnThisPosition(l_row, l_column-2))
        {
            rememberMove();
            m_board[l_row][l_column] = 0;
            m_board[l_row][l_column-1] = 0;
            m_board[l_row][l_column-2] = 1;
            return true;
        }
        return false;
    }
 
    public boolean moveRight(int l_row, int l_column)
    {
        if (isPegPositionOnBoard(l_row, l_column+2)
         && isPegOnThisPosition(l_row, l_column  )
         && isPegOnThisPosition(l_row, l_column+1)
        && !isPegOnThisPosition(l_row, l_column+2))
        {
            rememberMove();
            m_board[l_row][l_column] = 0;
            m_board[l_row][l_column+1] = 0;
            m_board[l_row][l_column+2] = 1;
            return true;
        }
        return false;
    }
    
    public boolean moveUp(int l_row, int l_column)
    {
        if (isPegPositionOnBoard(l_row-2, l_column)
         && isPegOnThisPosition(l_row, l_column  )
         && isPegOnThisPosition(l_row-1, l_column)
        && !isPegOnThisPosition(l_row-2, l_column))
        {
            rememberMove();
            m_board[l_row][l_column] = 0;
            m_board[l_row-1][l_column] = 0;
            m_board[l_row-2][l_column] = 1;
            return true;
        }
        return false;
    }
    
    public boolean moveDown(int l_row, int l_column)
    {
        if (isPegPositionOnBoard(l_row+2, l_column)
         && isPegOnThisPosition(l_row, l_column  )
         && isPegOnThisPosition(l_row+1, l_column)
        && !isPegOnThisPosition(l_row+2, l_column))
        {
            rememberMove();
            m_board[l_row][l_column] = 0;
            m_board[l_row+1][l_column] = 0;
            m_board[l_row+2][l_column] = 1;
            return true;
        }
        return false;
    }
    
    private boolean isPegOnThisPosition(int l_row, int l_column)
    {
         return m_board[l_row][l_column].equals(new Integer(1));
    }
    
    private boolean isPegPositionOnBoard(int l_row, int l_column)
    {
        if (!(l_row < 2 && (l_column < 2 || l_column > 4))
            && !(l_row > 4 && (l_column < 2 || l_column > 4))
            && (l_row >= 0) && (l_row <= 6)
            && (l_column >= 0) && (l_column <= 6))
        {
            return true;
        }
        return false;
    }
    
    private boolean isPositionCenter(int l_row, int l_column)
    {
        if ((l_row == 3 && l_column == 3))
        {
            return true;
        }
        return false;
    }  
    
    public void rememberMove()
    {
        Integer[][] l_board = new Integer[c_rows][c_columns];
        for (int l_row = 0; l_row < c_rows; ++l_row)
        {
            for (int l_column = 0; l_column < c_columns; ++l_column)
            {
                l_board[l_row][l_column] = m_board[l_row][l_column];
            }
        }
        m_history.add(l_board);
    }
    
    public void revertLastMove()
    {
        if (m_history.size() != 1)
        {
            Integer[][] l_board = m_history.get(m_history.size()-1);
            m_history.remove(m_history.get(m_history.size()-1));
            m_board = m_history.get(m_history.size()-1);
        }
        
    }
    
    
    private final int c_rows    = 7;
    private final int c_columns = c_rows;
    private ArrayList<Integer[][]> m_history = new ArrayList<Integer[][]>() ;
    private Integer[][] m_board = new Integer[c_rows][c_columns];
}
