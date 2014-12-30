/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownia10_packman;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Marek
 */
public class Game extends Canvas
{
    private static final long serialVersionUID = 1;
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 300;
    public static final int scale = 2;
    public static final String GAME_NAME = "Pacman - v0.1";
    public static final Dimension GAME_DIM = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    
    
    public Game()
    {
    }
    
    public static void main(String[] args)
    {
        Game l_game = new Game();
        l_game.setPreferredSize(GAME_DIM);
        l_game.setMaximumSize(GAME_DIM);
        l_game.setMinimumSize(GAME_DIM);
        
        JFrame l_frame = new JFrame(GAME_NAME);
        l_frame.setLayout(new BorderLayout());
        l_frame.add(l_game, BorderLayout.CENTER);
        l_frame.pack();
        l_frame.setVisible(true);
        l_frame.setResizable(true);
        l_frame.setLocationRelativeTo(null);
        l_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
