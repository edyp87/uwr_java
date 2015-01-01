package Santa;

public class EntitiesPositions
{
    public EntitiesPositions(int p_width, int p_height)
    {
        m_width = p_width;
        m_height = p_height;
        m_board = new int[p_width * p_height];
        System.out.println(p_width * p_height);
    }
    
    public boolean setPosition(int p_x, int p_y)
    {
        if(m_board[m_width * p_y + p_x] != 1)
        {
            m_board[m_width * p_y + p_x] = 1;
            return true;
        }
        return false;
    }
    
    public void unsetPosition(int p_x, int p_y)
    {
        m_board[m_width * p_y + p_x] = 0;
    }
    
    
    private int m_width, m_height;
    private int[] m_board;
}
