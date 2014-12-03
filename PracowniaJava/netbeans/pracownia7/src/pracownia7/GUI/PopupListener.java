/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownia7.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Marek
 */
public class PopupListener implements ActionListener
{
    PopupListener(PegSolitaireGUI p_gui)
    {
        m_gui = p_gui;
    }

    
    PegSolitaireGUI m_gui = null;

    @Override
    public void actionPerformed(ActionEvent e) {
          /*      System.out.println("POPUPLISTENER!");
            if(m_gui.m_state.isGameOver()) return;
            int p_clickedRow = m_gui.m_state.getClickedRow();
            int p_clickedColumn = m_gui.m_state.getClickedColumn();
            
            m_gui.m_state.click(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            m_gui.repaintNeighbors(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            if(m_gui.m_state.isAnyMovePossible())
                m_gui.m_scoreLabel.setText("Wykonano ruchów: " + m_gui.m_state.getMoves());
            else
                m_gui.m_scoreLabel.setText("Nie można już wykonać żadego ruchu!");
            m_gui.repaintPeg(p_clickedRow * 7 + p_clickedColumn);*/
    }
}
