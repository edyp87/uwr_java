package Santa;

public class EntitiesPositions
{
    public EntitiesPositions(int p_width, int p_height)
    {
        m_width = p_width;
        m_height = p_height;
        m_board = new int[p_width * p_height];
    }
    
    public boolean setPosition(int p_x, int p_y)
    {
        return true;
    }
    
    
    private int m_width, m_height;
    private int[] m_board;
}
