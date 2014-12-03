package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pracownia7.GUI.GuiState;
import pracownia7.GUI.PegSolitaireGUI;
import pracownia7.PegSolitaire.BoardBritish;
import pracownia7.PegSolitaire.BoardEuropean;

public class MenuBritishGame implements ActionListener
{
    public MenuBritishGame(PegSolitaireGUI p_gui)
    {
        m_gui = p_gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        m_gui.changeGame(new BoardBritish());
    }
    
    PegSolitaireGUI m_gui;
}
