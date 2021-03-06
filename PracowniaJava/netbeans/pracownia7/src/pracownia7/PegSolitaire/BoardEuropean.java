package pracownia7.PegSolitaire;

import java.util.ArrayList;

public class BoardEuropean implements IBoard
{
    public BoardEuropean()
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
        if (canMoveLeft(l_row, l_column))
        {
            rememberMove();
            m_numberOfPegs--;
            m_board[l_row][l_column] = 0;
            m_board[l_row][l_column-1] = 0;
            m_board[l_row][l_column-2] = 1;
            return true;
        }
        return false;
    }
 
    public boolean moveRight(int l_row, int l_column)
    {
        if (canMoveRight(l_row, l_column))
        {
            rememberMove();
            m_numberOfPegs--;
            m_board[l_row][l_column] = 0;
            m_board[l_row][l_column+1] = 0;
            m_board[l_row][l_column+2] = 1;
            return true;
        }
        return false;
    }
    
    public boolean moveUp(int l_row, int l_column)
    {
        if (canMoveUp(l_row, l_column))
        {
            rememberMove();
            m_numberOfPegs--;
            m_board[l_row][l_column] = 0;
            m_board[l_row-1][l_column] = 0;
            m_board[l_row-2][l_column] = 1;
            return true;
        }
        return false;
    }
    
    public boolean moveDown(int l_row, int l_column)
    {
        if (canMoveDown(l_row, l_column))
        {
            rememberMove();
            m_numberOfPegs--;
            m_board[l_row][l_column] = 0;
            m_board[l_row+1][l_column] = 0;
            m_board[l_row+2][l_column] = 1;
            return true;
        }
        return false;
    }
    
    public boolean isAnyMovePossible()
    {
        for (int l_row = 0; l_row < c_rows; ++l_row)
        {
            for (int l_column = 0; l_column < c_columns; ++l_column)
            {
                if (isMoveInAnyDirectionPossible(l_row, l_column))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
        
    public void resetBoard()
    {
         m_history = new ArrayList<Integer[][]>() ;
         m_board = new Integer[c_rows][c_columns];
         initBoardWithDefaultSetting();
         rememberMove();
    }
    
    private boolean canMoveDown(int l_row, int l_column)
    {
        System.out.println("canMoveDown");
        if (isPegPositionOnBoard(l_row+2, l_column)
            && isPegOnThisPosition(l_row, l_column  )
            && isPegOnThisPosition(l_row+1, l_column)
            && !isPegOnThisPosition(l_row+2, l_column))
        {
            return true;
        }
        return false;
    }
    
    private boolean canMoveUp(int l_row, int l_column)
    {
        System.out.println("canMoveUp");
        if (isPegPositionOnBoard(l_row-2, l_column)
            && isPegOnThisPosition(l_row, l_column  )
            && isPegOnThisPosition(l_row-1, l_column)
            && !isPegOnThisPosition(l_row-2, l_column))
        {
            return true;
        }
        return false;
    }
    
    private boolean canMoveLeft(int l_row, int l_column)
    {
        System.out.println("canMoveLeft");
        if (isPegPositionOnBoard(l_row, l_column-2)
            && isPegOnThisPosition(l_row, l_column  )
            && isPegOnThisPosition(l_row, l_column-1)
            && !isPegOnThisPosition(l_row, l_column-2))
        {
            return true;
        }
        return false;
    } 
    
    private boolean canMoveRight(int l_row, int l_column)
    {
        System.out.println("canMoveRight");
        if (isPegPositionOnBoard(l_row, l_column+2)
            && isPegOnThisPosition(l_row, l_column  )
            && isPegOnThisPosition(l_row, l_column+1)
            && !isPegOnThisPosition(l_row, l_column+2))
        {
            return true;
        }
        return false;
    } 
        
    private boolean isMoveInAnyDirectionPossible(int l_row, int l_column)
    {
        return canMoveRight(l_row, l_column) || 
               canMoveLeft (l_row, l_column) ||
               canMoveDown (l_row, l_column) ||
               canMoveUp   (l_row, l_column);
    }
    
    public boolean isPegOnThisPosition(int l_row, int l_column)
    {
        System.out.println("ISPEGONTHISPOS:" + l_row + " " + l_column);
         return m_board[l_row][l_column].equals(new Integer(1));
    }
    
    public boolean isPegPositionOnBoard(int l_row, int l_column)
    {
        if (((l_row == 0) && (l_column < 2 || l_column > 4))
            || ((l_row == 1) && (l_column == 0 || l_column == 6))
            || ((l_row == 6) && (l_column < 2 || l_column > 4)) 
            || ((l_row == 5) && (l_column == 0 || l_column == 6))
            || l_row < 0 || l_row >= c_rows || l_column < 0 || l_column >= c_columns
           )
        {
            return false;
        }
        return true;
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
    
    public int numberfPegs()
    {
        return m_numberOfPegs;
    }
    
    public int getHeight()
    {
        return c_rows;
    }
    
    public int getWeight()
    {
        return c_columns;
    }
            
    
    
    private final int c_rows    = 7;
    private final int c_columns = c_rows;
    private int m_numberOfPegs  = 36;
    private ArrayList<Integer[][]> m_history = new ArrayList<Integer[][]>() ;
    private Integer[][] m_board = new Integer[c_rows][c_columns];
}
