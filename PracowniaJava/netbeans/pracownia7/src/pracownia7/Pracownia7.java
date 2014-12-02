/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownia7;

import pracownia7.GUI.PegSolitaireGUI;
import pracownia7.PegSolitaire.Board;

/**
 *
 * @author Marek
 */
public class Pracownia7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board l_board = new Board();
        l_board.moveLeft(3, 5);
        l_board.revertLastMove();
        l_board.printBoard();
        
        (new PegSolitaireGUI()).initialize();
    }
    
}
