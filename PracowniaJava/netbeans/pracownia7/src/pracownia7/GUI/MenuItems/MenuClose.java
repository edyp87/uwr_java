package pracownia7.GUI.MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuClose implements ActionListener
{
    public MenuClose(JFrame p_frame)
    {
        m_frame = p_frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {/*
        Object[] options = {"Tak",
                    "Nie",
                    "Anuluj"};
        int n = JOptionPane.showOptionDialog(null,
            "Czy chcesz zakonczyc gre?",
            "Koniec?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[2]);
        
        if (n == 0)*/
            m_frame.dispatchEvent(new WindowEvent(m_frame, WindowEvent.WINDOW_CLOSING));
    }
    
    JFrame m_frame = null;
}
