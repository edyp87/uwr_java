package pracownia7.PegSolitaire;

import java.util.ArrayList;

public interface IBoard
{
    public void printBoard();
    
    public Integer[][] getBoard();
    
    public boolean moveLeft(int l_row, int l_column);
 
    public boolean moveRight(int l_row, int l_column);
    
    public boolean moveUp(int l_row, int l_column);
    
    public boolean moveDown(int l_row, int l_column);
    
    public boolean isAnyMovePossible();
    
    public boolean isPegOnThisPosition(int l_row, int l_column);
    
    public boolean isPegPositionOnBoard(int l_row, int l_column);
    
    public int numberfPegs();
    
    public int getHeight();
    
    public int getWeight();
    
    public void rememberMove();
    
    public void revertLastMove();
    
    public void resetBoard();
}
