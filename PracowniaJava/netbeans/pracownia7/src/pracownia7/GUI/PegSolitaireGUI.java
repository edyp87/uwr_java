package pracownia7.GUI;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import pracownia7.GUI.MenuItems.MenuAboutListener;
import pracownia7.GUI.MenuItems.MenuBritishGame;
import pracownia7.GUI.MenuItems.MenuClose;
import pracownia7.GUI.MenuItems.MenuEuropeanGame;
import pracownia7.GUI.MenuItems.MenuHelpListener;
import pracownia7.GUI.MenuItems.MenuJumpDown;
import pracownia7.GUI.MenuItems.MenuJumpLeft;
import pracownia7.GUI.MenuItems.MenuJumpRight;
import pracownia7.GUI.MenuItems.MenuJumpUp;
import pracownia7.GUI.MenuItems.MenuNew;
import pracownia7.PegSolitaire.BoardBritish;
import pracownia7.PegSolitaire.BoardEuropean;
import pracownia7.PegSolitaire.IBoard;

public class PegSolitaireGUI
{
    public PegSolitaireGUI()
    {
        initialize();
    }
    
    private void createMainFrame()
    {
        m_mainFrame = new JFrame("Peg Solitaire");
        m_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_mainFrame.setSize(448, 499);
        m_mainFrame.setResizable(false);
    }
    
    private void createMenuBar()
    {
        JMenuBar l_mainMenuBar = new JMenuBar();
        
        JMenu l_menuGra = addMenu(l_mainMenuBar, "Gra",        KeyEvent.VK_G);
            addMenuItem(l_menuGra, "Nowa", new MenuNew(m_state, this));
            addMenuItem(l_menuGra, "Graj w wersję europejską", new MenuEuropeanGame(this));
            addMenuItem(l_menuGra, "Graj w wersję brytyjską", new MenuBritishGame(this));
            l_menuGra.add(new JSeparator());
            addMenuItem(l_menuGra, "Koniec", new MenuClose(m_mainFrame));
        JMenu l_menuRuchy = addMenu(l_mainMenuBar, "Ruchy",      KeyEvent.VK_R);
            addMenuItem(l_menuRuchy, "Wybierz pole", new MenuHelpListener());
            l_menuRuchy.add(new JSeparator());
            addMenuItem(l_menuRuchy, "Bij w lewo", new MenuJumpLeft(m_state, this));
            addMenuItem(l_menuRuchy, "Bij w prawo", new  MenuJumpRight(m_state, this));
            addMenuItem(l_menuRuchy, "Bij w dol", new MenuJumpDown(m_state, this));
            addMenuItem(l_menuRuchy, "Bij w gore", new MenuJumpUp(m_state, this));
        JMenu l_menuUstaw = addMenu(l_mainMenuBar, "Ustawienia", KeyEvent.VK_U);
        l_mainMenuBar.add(Box.createHorizontalGlue());
        JMenu l_menuPomoc = addMenu(l_mainMenuBar, "Pomoc",      KeyEvent.VK_P);
            addMenuItem(l_menuPomoc, "O grze", new MenuHelpListener());
            addMenuItem(l_menuPomoc, "O aplikacji", new MenuAboutListener());
        
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
                    l_peg.addMouseListener(new MouseRightClick(this));
                }
                else if (!m_board.isPegPositionOnBoard(l_row, l_column))
                {
                    Peg l_peg = new Peg("peg-disabled.png", l_row, l_column);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                }
                else
                {
                    Peg l_peg = new Peg("peg-grey.png", l_row, l_column);
                    m_boardPanel.add(l_peg);
                    l_peg.addActionListener(new PegListener(this));
                    l_peg.addMouseListener(new MouseRightClick(this));
                }
            }
        }
        m_splitPanel.add(m_boardPanel);
    }
    
    private void createScoreLabel()
    {
        m_scoreLabel = new JLabel("Wykonano ruchów: " + m_state.getMoves());
        m_scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        m_splitPanel.add(m_scoreLabel);
    }
    
    private void createSplitPanel()
    {
        m_splitPanel = new JPanel();
        m_splitPanel.setLayout(new BoxLayout(m_splitPanel, BoxLayout.Y_AXIS));
        m_mainFrame.add(m_splitPanel, BoxLayout.X_AXIS);
    }
    
    public void repaintAll()
    {
        for (int l_peg = 0; l_peg < m_board.getHeight() * m_board.getWeight(); ++l_peg)
        {
            repaintPeg(l_peg);     
        } 
        m_scoreLabel.setText("Wykonano ruchów: " + m_state.getMoves());
    }
    
    private void initialize()
    {
        m_board = new BoardBritish();
        m_state = new GuiState(m_board);
        createMainFrame();
        createMenuBar();
        createSplitPanel();
        createBoard();
        createScoreLabel();
        m_mainFrame.setVisible(true);  
    }
    
    public void repaintPeg(int p_componentNumber)
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
    
    public void injectGame(IBoard p_game)
    {
        m_board = p_game;
        repaintAll();
        m_state.resetBoard(p_game);
    }
    
    private JMenu addMenu(JMenuBar p_menuBar, String p_menuName, int p_keyStroke)
    {
        JMenu l_menu = new JMenu(p_menuName);
        l_menu.setMnemonic(p_keyStroke);
        p_menuBar.add(l_menu);
        return l_menu;
    }
    
    private void addMenuItem(JMenu p_menu, String p_menuName, ActionListener p_actionListener)
    {
        JMenuItem l_menu = new JMenuItem(p_menuName);
        l_menu.addActionListener(p_actionListener);
        p_menu.add(l_menu);
    }

    public void repaintNeighbors(int p_row, int p_column)
    {
        repaintPeg(p_row*m_board.getHeight() + p_column);
        if (p_row-1 >= 0) repaintPeg((p_row-1)*m_board.getWeight() + p_column);
        if (p_row-2 >= 0) repaintPeg((p_row-2)*m_board.getWeight() + p_column);
        if (p_row+1 < m_board.getHeight())  repaintPeg((p_row+1)*m_board.getWeight() + p_column);
        if (p_row+2 < m_board.getHeight())  repaintPeg((p_row+2)*m_board.getWeight() + p_column);
        
        if (p_column-1 >= 0) repaintPeg((p_row)*m_board.getWeight() + p_column-1);
        if (p_column-2 >= 0) repaintPeg((p_row)*m_board.getWeight() + p_column-2);
        if (p_column+1 < m_board.getHeight())  repaintPeg((p_row)*m_board.getWeight() + p_column+1);
        if (p_column+2 < m_board.getHeight())  repaintPeg((p_row)*m_board.getWeight() + p_column+2);
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
            if(m_state.isGameOver()) return;
            int p_clickedRow = m_state.getClickedRow();
            int p_clickedColumn = m_state.getClickedColumn();
            
            m_state.click(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            m_gui.repaintNeighbors(((Peg)e.getSource()).getRow(), ((Peg)e.getSource()).getColumn());
            if(m_state.isAnyMovePossible())
                m_scoreLabel.setText("Wykonano ruchów: " + m_state.getMoves());
            else
                m_scoreLabel.setText("Nie można już wykonać żadego ruchu!");
            m_gui.repaintPeg(p_clickedRow * 7 + p_clickedColumn);
        }
        
        PegSolitaireGUI m_gui;
    }
    
    private class MouseRightClick extends MouseAdapter
    {
        public MouseRightClick(PegSolitaireGUI p_gui)
        {
            m_gui = p_gui;
        }
        
        public void mousePressed(MouseEvent e)
        {
            if (e.isPopupTrigger())
                doPop(e);
        }

        public void mouseReleased(MouseEvent e)
        {
            if (e.isPopupTrigger())
                doPop(e);
        }

        private void doPop(MouseEvent e)
        {
            PopUpMenu menu = new PopUpMenu(m_gui);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
        PegSolitaireGUI m_gui;
    }
    
    JPanel   m_boardPanel;
    IBoard   m_board;
    GuiState m_state;
    JLabel   m_scoreLabel;
    JPanel   m_splitPanel;
    JFrame   m_mainFrame;
}
