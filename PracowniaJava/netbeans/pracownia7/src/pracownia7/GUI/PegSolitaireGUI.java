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
        m_boardPanel = new JPanel();
        m_boardPanel.setLayout(new GridLayout(m_board.getHeight(), m_board.getWeight()));
        
        for (int l_row = 0; l_row < m_board.getHeight(); ++l_row)
        {
            for (int l_column = 0; l_column < m_board.getWeight(); ++l_column)
            {
                if(m_board.isPegOnThisPosition(l_row, l_column))
                {
                    Peg l_peg = new Peg("peg-green.png", l_row, l_column);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                    
                }
                else if (!m_board.isPegPositionOnBoard(l_row, l_column))
                {
                    Peg l_peg = new Peg("peg-disabled.png", l_row, l_column);
                    m_boardPanel.add(l_peg);
                }
                else
                {
                    Peg l_peg = new Peg("peg-grey.png", l_row, l_column);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                }
            }
        }
        m_mainFrame.add(m_boardPanel);
    }
    
    public void repaintAll()
    {
        for (int l_peg = 0; l_peg < m_board.getHeight() * m_board.getWeight(); ++l_peg)
        {
            repaintPeg(l_peg);     
        } 
    }
    
    private void repaintPeg(int p_componentNumber)
    {
        if(m_state.isClicked(p_componentNumber / m_board.getHeight(),
                             p_componentNumber % m_board.getWeight()) 
           && m_board.isPegOnThisPosition(p_componentNumber / m_board.getHeight(),
                                          p_componentNumber % m_board.getWeight()))
        {
            ((Peg)m_boardPanel.getComponent(p_componentNumber)).changeImage("peg-chosen.png");
        }
        else if(m_board.isPegOnThisPosition(p_componentNumber / m_board.getHeight(),
                                            p_componentNumber % m_board.getWeight()))
        {
            ((Peg)m_boardPanel.getComponent(p_componentNumber)).changeImage("peg-green.png");           
        }
        else if (!m_board.isPegPositionOnBoard(p_componentNumber / m_board.getHeight(),
                                               p_componentNumber % m_board.getWeight()))
        {
            ((Peg)m_boardPanel.getComponent(p_componentNumber)).changeImage("peg-disabled.png");
        }
        else
        {
            ((Peg)m_boardPanel.getComponent(p_componentNumber)).changeImage("peg-grey.png");
        }
    }
    
    private void addMenu(JMenuBar p_menuBar, String p_menuName, int p_keyStroke)
    {
        JMenu l_menu = new JMenu(p_menuName);
        l_menu.setMnemonic(p_keyStroke);
        p_menuBar.add(l_menu);
    }

    private void repaintNeighbors(int p_row, int p_column)
    {
        repaintPeg(p_row*7 + p_column);
        if (p_row-1 >= 0) repaintPeg((p_row-1)*7 + p_column);
        if (p_row-2 >= 0) repaintPeg((p_row-2)*7 + p_column);
        if (p_row+1 < 7)  repaintPeg((p_row+1)*7 + p_column);
        if (p_row+2 < 7)  repaintPeg((p_row+2)*7 + p_column);
        
        if (p_column-1 >= 0) repaintPeg((p_row)*7 + p_column-1);
        if (p_column-2 >= 0) repaintPeg((p_row)*7 + p_column-2);
        if (p_column+1 < 7)  repaintPeg((p_row)*7 + p_column+1);
        if (p_column+2 < 7)  repaintPeg((p_row)*7 + p_column+2);
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
            
            int p_clickedRow = m_state.getClickedRow();
            int p_clickedColumn = m_state.getClickedColumn();
            
            m_state.click(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            m_gui.repaintNeighbors(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            
            m_gui.repaintPeg(p_clickedRow * 7 + p_clickedColumn);
        }
        PegSolitaireGUI m_gui;
    }
    
    JPanel   m_boardPanel;
    Board    m_board = new Board();
    GuiState m_state = new GuiState(m_board);
    JFrame   m_mainFrame;
}
