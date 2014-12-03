package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MenuHelpListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, 
                "Celem gry jest zostawienie na planszy jednego piona. \n"
                        + "Idealnym rozwiązaniem jest jeden pion, pozostawiony na środku. \n"
                        + "Piony bije się przeskakując je. Nie wolno ich przeskakiwać na ukos.", "Zasady gry", JOptionPane.INFORMATION_MESSAGE);
    }
}
