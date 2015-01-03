package Sprites;

public class SpriteContainer
{
    public static int s_tileSize = 48;
    
   public static Sprite[][] s_terrain = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize);
   public static Sprite s_player = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize)[2][0];
   public static Sprite s_child = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize)[4][0];
   public static Sprite s_childSleeping = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize)[4][1];
   public static Sprite s_present = SpriteLoader.cutTile("/res/terrain3.png", s_tileSize, s_tileSize)[3][0];
   
   public static int tileToPix(int p_val, int p_tileSize)
   {
       return p_val * p_tileSize;
   }
   
   
}
