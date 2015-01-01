package Units;

public class TileUnit extends Unit
{
    private int m_tileSize = 0;
    
    public TileUnit(int p_width, int p_height)
    {
        super(p_width, p_height);
    }
    
    public TileUnit(int p_width, int p_height, int p_tileSize)
    {
        super(p_width, p_height);
        m_tileSize = p_tileSize;
    }
    
    public TileUnit(PixelUnit p_pixels, int p_tileSize)
    {
        super(p_pixels.getWidth()  / p_tileSize, 
              p_pixels.getHeight() / p_tileSize);
        m_tileSize = p_tileSize;
    }
    
    public int getTileSize()
    {
        return m_tileSize;
    }
    
    public int getNumberOfTiles()
    {
        return getWidth() * getHeight();
    }
    
    
    
    
}
