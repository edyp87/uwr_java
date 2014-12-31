package Sprites;

public class SpriteContainer
{
    public static int s_tileSize = 48;
    
   public static Sprite[][] s_terrain = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize);
   public static Sprite s_player = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize)[2][0];
   
   
}
