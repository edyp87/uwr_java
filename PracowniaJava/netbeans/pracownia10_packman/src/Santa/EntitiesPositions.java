package Santa;

public class EntitiesPositions
{
    public EntitiesPositions(int p_width, int p_height)
    {
        m_width = p_width;
        m_height = p_height;
        m_board = new int[p_width * p_height];
    }
    
    public synchronized boolean setSantaPosition(int p_x, int p_y)
    {
        if(m_board[m_width * p_y + p_x] != 1 || m_board[m_width * p_y + p_x] != 2)
        {
            m_board[m_width * p_y + p_x] = 2;
            m_santaPosition = m_width * p_y + p_x;
            return true;
        }
        return false;
    }
    
    public synchronized boolean setPosition(int p_x, int p_y)
    {
        if(m_board[m_width * p_y + p_x] != 1 || m_board[m_width * p_y + p_x] != 2)
        {
            m_board[m_width * p_y + p_x] = 1;
            return true;
        }
        return false;
    }
    
    public int isSantaInRadius(int p_x, int p_y)
    {
        for(int i = 0; i < m_board.length; ++i)
        {
            if(m_board[i] == 2)
            {
                int l_santaX = i % m_width;
                int l_santaY = i / m_width;
                int l_diffX  = Math.abs(l_santaX - p_x);
                int l_diffY  = Math.abs(l_santaY - p_y);
                int l_minDiff = Math.min(l_diffX, l_diffY);
                if (l_diffX < 10)
                {
                    if (l_diffY < l_diffX)
                    {
                        if(l_santaY - p_y < 0)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    if(l_santaX - p_x < 0)
                    {
                        return 3;
                    }
                    else
                    {
                        return 1;
                    }
                }
            }
        }
        return 4;
    }
    
    public synchronized void unsetPosition(int p_x, int p_y)
    {
        m_board[m_width * p_y + p_x] = 0;
    }
    
    
    
    private int m_width, m_height;
    private int m_santaPosition;
    private int[] m_board;
}
