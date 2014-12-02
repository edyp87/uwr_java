package pracownia7.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JFrame;
import pracownia7.PegSolitaire.Board;

public class PegSolitaireGUI
{
    public void initialize()
    {
        createMainFrame();
        createMenuBar();
        createBoard();
        m_mainFrame.setVisible(true);  
    }
    private void createMainFrame()
    {
        m_mainFrame = new JFrame("Peg Solitaire");
        m_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_mainFrame.setSize(448, 499);
    }
    
    private void createMenuBar()
    {
        JMenuBar l_mainMenuBar = new JMenuBar();
        
        addMenu(l_mainMenuBar, "Gra",        KeyEvent.VK_G);
        addMenu(l_mainMenuBar, "Ruchy",      KeyEvent.VK_R);
        addMenu(l_mainMenuBar, "Ustawienia", KeyEvent.VK_U);
        addMenu(l_mainMenuBar, "Pomoc",      KeyEvent.VK_P);
        
        m_mainFrame.setJMenuBar(l_mainMenuBar);
    }
    
    private void createBoard()
    {
        Integer[][] l_boardRepresentation = m_board.getBoard();
        JPanel l_boardPanel = new JPanel();
        l_boardPanel.setLayout(new GridLayout(7, 7));
        
        for (int i = 0; i < 7; ++i)
        {
            for (int j = 0; j < 7; ++j)
            {
                if(l_boardRepresentation[i][j] == 1)
                {
                    Peg l_peg = new Peg("peg-green.png");
                    l_boardPanel.add(l_peg);
                    l_peg.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            ((Peg)(e.getSource())).changeImage("peg-grey.png");
                        }
                    });
                    
                }
                else if (!m_board.isPegPositionOnBoard(i, j))
                {
                    Peg l_peg = new Peg("peg-disabled.png");
                    l_boardPanel.add(l_peg);
                }
                else
                {
                    Peg l_peg = new Peg("peg-grey.png");
                    l_boardPanel.add(l_peg);
                }
            }
        }
        //((Peg)l_boardPanel.getComponent(0)).changeImage("peg-green.png");
        m_mainFrame.add(l_boardPanel);
    }
    
    private void addMenu(JMenuBar p_menuBar, String p_menuName, int p_keyStroke)
    {
        JMenu l_menu = new JMenu(p_menuName);
        l_menu.setMnemonic(p_keyStroke);
        p_menuBar.add(l_menu);
    }
    
    Board    m_board = new Board();
    GuiState m_state = new GuiState(m_board);
    JFrame   m_mainFrame;
}
