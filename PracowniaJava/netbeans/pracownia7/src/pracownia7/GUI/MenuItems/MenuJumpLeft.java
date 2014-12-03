package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pracownia7.GUI.GuiState;
import pracownia7.GUI.PegSolitaireGUI;

public class MenuJumpLeft implements ActionListener
{
    public MenuJumpLeft(GuiState p_state, PegSolitaireGUI p_gui)
    {
        m_state = p_state;
        m_gui = p_gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(m_state.isClicked())
        {
            int l_row = m_state.getClickedRow();
            int l_column = m_state.getClickedColumn();
            m_state.click(l_row, l_column-2);
            m_gui.repaintNeighbors(l_row, l_column);
        }
        
    }
    
    GuiState m_state = null;
    PegSolitaireGUI m_gui;
}
