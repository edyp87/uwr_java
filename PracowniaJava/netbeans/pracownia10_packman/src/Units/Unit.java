package Units;

public abstract class Unit
{
    private int m_width  = 0;
    private int m_height = 0;
    
    public Unit(int p_width, int p_height)
    {
        m_width  = p_width;
        m_height = p_height;
    }
    
    public int getHeight()
    {
        return m_height;
    }
    
    public int getWidth()
    {
        return m_width;
    }
    
}
