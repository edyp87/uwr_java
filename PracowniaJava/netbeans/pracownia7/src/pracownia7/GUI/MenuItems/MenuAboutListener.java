package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MenuAboutListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, 
                "Marek Jenda <marek.jenda@gmail.com>", "Autor", JOptionPane.INFORMATION_MESSAGE);
    }
}
