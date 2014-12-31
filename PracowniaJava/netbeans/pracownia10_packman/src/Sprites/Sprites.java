package Sprites;

public class Sprites
{
   public static Sprite[][] m_terrain = SpriteSheetLoader.cutTile("/res/terrain2.png", 16, 16);
   public static Sprite m_player = SpriteSheetLoader.cutTile("/res/terrain2.png", 16, 16)[2][0];
}
