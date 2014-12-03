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
}