package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pracownia7.GUI.GuiState;
import pracownia7.GUI.PegSolitaireGUI;

public class MenuNew implements ActionListener
{
    public MenuNew(GuiState p_state, PegSolitaireGUI p_gui)
    {
        m_state = p_state;
        m_gui = p_gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        m_state.resetBoard();
        m_gui.repaintAll();
    }
    
    GuiState m_state = null;
    PegSolitaireGUI m_gui;
}
