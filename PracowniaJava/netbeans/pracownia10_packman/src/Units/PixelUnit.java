
package Units;

public class PixelUnit extends Unit
{
    public PixelUnit(int p_width, int p_height)
    {
        super(p_width, p_height);
    }
    
    public PixelUnit(TileUnit p_tile)
    {
        super(p_tile.getWidth()  * p_tile.getTileSize(),
              p_tile.getHeight() * p_tile.getTileSize());
    }
}
