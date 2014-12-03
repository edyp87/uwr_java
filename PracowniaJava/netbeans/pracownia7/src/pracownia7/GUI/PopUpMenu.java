package pracownia7.GUI;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu
{
    JMenuItem anItem;
    public PopUpMenu(PegSolitaireGUI p_gui)
    {
        anItem = new JMenuItem("Click Me!");
        add(anItem);
        anItem.addActionListener(new PopupListener(p_gui));
    }
    
    /*
                if(m_state.isGameOver()) return;
            int p_clickedRow = m_state.getClickedRow();
            int p_clickedColumn = m_state.getClickedColumn();
            
            m_state.click(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            m_gui.repaintNeighbors(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            if(m_state.isAnyMovePossible())
                m_scoreLabel.setText("Wykonano ruchów: " + m_state.getMoves());
            else
                m_scoreLabel.setText("Nie można już wykonać żadego ruchu!");
            m_gui.repaintPeg(p_clickedRow * 7 + p_clickedColumn);
    */
}