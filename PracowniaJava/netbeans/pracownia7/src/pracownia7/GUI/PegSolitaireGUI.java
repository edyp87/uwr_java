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
        m_boardPanel = new JPanel();
        m_boardPanel.setLayout(new GridLayout(7, 7));
        
        for (int i = 0; i < 7; ++i)
        {
            for (int j = 0; j < 7; ++j)
            {
                if(l_boardRepresentation[i][j] == 1)
                {
                    Peg l_peg = new Peg("peg-green.png", i, j);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                    
                }
                else if (!m_board.isPegPositionOnBoard(i, j))
                {
                    Peg l_peg = new Peg("peg-disabled.png", i, j);
                    m_boardPanel.add(l_peg);
                }
                else
                {
                    Peg l_peg = new Peg("peg-grey.png", i, j);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                }
            }
        }
        //((Peg)l_boardPanel.getComponent(0)).changeImage("peg-green.png");
        m_mainFrame.add(m_boardPanel);
    }
    
    public void repaint()
    {
        Integer[][] l_boardRepresentation = m_board.getBoard();
        for (int i = 0; i < 49; ++i)
        {
                if(l_boardRepresentation[i / 7][i % 7] == 1)
                {
                    ((Peg)m_boardPanel.getComponent(i)).changeImage("peg-green.png");
                    
                }
                else if (!m_board.isPegPositionOnBoard(i / 7, i % 7))
                {
                    ((Peg)m_boardPanel.getComponent(i)).changeImage("peg-disabled.png");
                }
                else
                {
                    ((Peg)m_boardPanel.getComponent(i)).changeImage("peg-grey.png");
                }
            
        } 
    }
    
    private void addMenu(JMenuBar p_menuBar, String p_menuName, int p_keyStroke)
    {
        JMenu l_menu = new JMenu(p_menuName);
        l_menu.setMnemonic(p_keyStroke);
        p_menuBar.add(l_menu);
    }
    
    private class PegListener implements ActionListener
    {
        public PegListener(PegSolitaireGUI p_gui)
        {
            m_gui = p_gui;
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            m_state.click(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            //((Peg)e.getSource()).changeImage();
            m_gui.repaint();
            
            
        }
        
        PegSolitaireGUI m_gui;
    }
    
    JPanel   m_boardPanel;
    Board    m_board = new Board();
    GuiState m_state = new GuiState(m_board);
    JFrame   m_mainFrame;
}
