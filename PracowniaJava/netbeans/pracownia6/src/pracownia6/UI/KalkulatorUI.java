
package pracownia6.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import pracownia6.Processor.Processor;
import pracownia6.Przyciski.IPrzycisk;
import pracownia6.Przyciski.PrzyciskDodawania;
import pracownia6.Przyciski.PrzyciskNumeryczny;
import pracownia6.Przyciski.PrzyciskWyniku;

public class KalkulatorUI implements IKalkulatorUI
{
    public KalkulatorUI()
    {
        utworzOknoGlowne();
        utworzPoleTekstowe();
        utworzPanelZPrzyciskami();
    }
    
    @Override
    public void wyswietlKalkulator()
    {
        m_ramkaGlowna.setVisible(true);
    }
    
    private void utworzOknoGlowne()
    {
        m_panel = new Panel();
        m_panel.setLayout(new BorderLayout());
        
        m_ramkaGlowna = new Frame();
        m_ramkaGlowna.add("Center", m_panel);
        m_ramkaGlowna.setBounds(10, 10, 250, 250);
        m_ramkaGlowna.setTitle("Kalkular BigIntegerowy");
        m_ramkaGlowna.addWindowListener(new Closer());
        
        wysrodkujOkno(m_ramkaGlowna);
    }
    
    private void utworzPoleTekstowe()
    {
        m_poleTekstowe = new TextField("0");
        m_panel.add("North", m_poleTekstowe);  
    }
    
    private void utworzPanelZPrzyciskami()
    {
        m_panelZPrzyciskami = new Panel();
        m_panelZPrzyciskami.setLayout(new GridLayout(5,4));
        
        utworzPrzyciski();
        utworzWarstweLogicznaPrzyciskow();
        dodajPrzyciskiDoPanelu();
        
        m_panel.add("Center", m_panelZPrzyciskami);
    }
    
    private void utworzPrzyciski()
    {
        m_przycisk_1 = new Button("1");
        m_przycisk_2 = new Button("2");
        m_przycisk_3 = new Button("3");
        m_przycisk_4 = new Button("4");
        m_przycisk_5 = new Button("5");
        m_przycisk_6 = new Button("6");
        m_przycisk_7 = new Button("7");
        m_przycisk_8 = new Button("8");
        m_przycisk_9 = new Button("9");
        m_przycisk_0 = new Button("0");
        
        m_usunCyfre  = new Button("<-");
        m_modulo     = new Button("%");
        m_dzielenie  = new Button("/");
        m_mnozenie   = new Button("*");
        m_odejmowanie= new Button("-");
        m_dodawanie  = new Button("+");
        m_symbolNewt = new Button("xCy");
        m_potega     = new Button("^");
        m_oblicz     = new Button("=");
        m_pusty      = new Button("");
    }
    
    private void utworzWarstweLogicznaPrzyciskow()
    {
        m_LogPrzycisk_1 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(1));
        m_LogPrzycisk_2 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(2));
        m_LogPrzycisk_3 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(3));
        m_LogPrzycisk_4 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(4));
        m_LogPrzycisk_5 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(5));
        m_LogPrzycisk_6 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(6));
        m_LogPrzycisk_7 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(7));
        m_LogPrzycisk_8 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(8));
        m_LogPrzycisk_9 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(9));
        m_LogPrzycisk_0 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(0));
        m_LogPrzycisk_oblicz    = new PrzyciskWyniku(m_kalkulator);
        m_LogPrzycisk_dodawanie = new PrzyciskDodawania(m_kalkulator);
        
        powiazPrzyciskiZListenerami();
    }
    
    private void powiazPrzyciskiZListenerami()
    {
        m_LogPrzycisk_1_Listener = new PrzyciskListener(m_LogPrzycisk_1);
        m_LogPrzycisk_2_Listener = new PrzyciskListener(m_LogPrzycisk_2);
        m_LogPrzycisk_3_Listener = new PrzyciskListener(m_LogPrzycisk_3);
        m_LogPrzycisk_4_Listener = new PrzyciskListener(m_LogPrzycisk_4);
        m_LogPrzycisk_5_Listener = new PrzyciskListener(m_LogPrzycisk_5);
        m_LogPrzycisk_6_Listener = new PrzyciskListener(m_LogPrzycisk_6);
        m_LogPrzycisk_7_Listener = new PrzyciskListener(m_LogPrzycisk_7);
        m_LogPrzycisk_8_Listener = new PrzyciskListener(m_LogPrzycisk_8);
        m_LogPrzycisk_9_Listener = new PrzyciskListener(m_LogPrzycisk_9);
        m_LogPrzycisk_0_Listener = new PrzyciskListener(m_LogPrzycisk_0);
        m_LogPrzycisk_oblicz_Listener = new PrzyciskListener(m_LogPrzycisk_oblicz);
        m_LogPrzycisk_dodawanie_Listener = new PrzyciskListener(m_LogPrzycisk_dodawanie);
        
        m_przycisk_1.addActionListener(m_LogPrzycisk_1_Listener);
        m_przycisk_2.addActionListener(m_LogPrzycisk_2_Listener);
        m_przycisk_3.addActionListener(m_LogPrzycisk_3_Listener);
        m_przycisk_4.addActionListener(m_LogPrzycisk_4_Listener);
        m_przycisk_5.addActionListener(m_LogPrzycisk_5_Listener);
        m_przycisk_6.addActionListener(m_LogPrzycisk_6_Listener);
        m_przycisk_7.addActionListener(m_LogPrzycisk_7_Listener);
        m_przycisk_8.addActionListener(m_LogPrzycisk_8_Listener);
        m_przycisk_9.addActionListener(m_LogPrzycisk_9_Listener);
        m_przycisk_0.addActionListener(m_LogPrzycisk_0_Listener);
        m_dodawanie.addActionListener(m_LogPrzycisk_dodawanie_Listener);
        m_oblicz.addActionListener(m_LogPrzycisk_oblicz_Listener);
    }
    
    private void dodajPrzyciskiDoPanelu()
    {
        m_panelZPrzyciskami.add(m_modulo);
        m_panelZPrzyciskami.add(m_dzielenie);
        m_panelZPrzyciskami.add(m_mnozenie);
        m_panelZPrzyciskami.add(m_odejmowanie);
        m_panelZPrzyciskami.add(m_przycisk_7);
        m_panelZPrzyciskami.add(m_przycisk_8);
        m_panelZPrzyciskami.add(m_przycisk_9);
        m_panelZPrzyciskami.add(m_dodawanie);
        m_panelZPrzyciskami.add(m_przycisk_4);
        m_panelZPrzyciskami.add(m_przycisk_5);
        m_panelZPrzyciskami.add(m_przycisk_6);
        m_panelZPrzyciskami.add(m_symbolNewt);
        m_panelZPrzyciskami.add(m_przycisk_1);
        m_panelZPrzyciskami.add(m_przycisk_2);
        m_panelZPrzyciskami.add(m_przycisk_3);
        m_panelZPrzyciskami.add(m_potega);
        m_panelZPrzyciskami.add(m_przycisk_0);
        m_panelZPrzyciskami.add(m_pusty);
        m_panelZPrzyciskami.add(m_oblicz);
        m_panelZPrzyciskami.add(m_usunCyfre);
    }
    
    public void wysrodkujOkno(Window p_frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()  - p_frame.getWidth())  / 2);
        int y = (int) ((dimension.getHeight() - p_frame.getHeight()) / 2);
        p_frame.setLocation(x, y);
    }
    
    private Panel     m_panel;
    private Frame     m_ramkaGlowna;
    private TextField m_poleTekstowe;
    private Panel     m_panelZPrzyciskami;
    private Button    m_modulo    , m_dzielenie , m_mnozenie  , m_odejmowanie,
                      m_przycisk_7, m_przycisk_8, m_przycisk_9, m_dodawanie  ,
                      m_przycisk_4, m_przycisk_5, m_przycisk_6, m_symbolNewt ,
                      m_przycisk_1, m_przycisk_2, m_przycisk_3, m_potega     ,
                      m_przycisk_0, m_pusty     , m_oblicz    , m_usunCyfre  ;

    private Processor          m_kalkulator = new Processor();
    private PrzyciskNumeryczny m_LogPrzycisk_1;
    private PrzyciskNumeryczny m_LogPrzycisk_2;
    private PrzyciskNumeryczny m_LogPrzycisk_3 ;
    private PrzyciskNumeryczny m_LogPrzycisk_4;
    private PrzyciskNumeryczny m_LogPrzycisk_5;
    private PrzyciskNumeryczny m_LogPrzycisk_6;
    private PrzyciskNumeryczny m_LogPrzycisk_7;
    private PrzyciskNumeryczny m_LogPrzycisk_8;
    private PrzyciskNumeryczny m_LogPrzycisk_9;
    private PrzyciskNumeryczny m_LogPrzycisk_0;
    private PrzyciskWyniku     m_LogPrzycisk_oblicz;
    private PrzyciskDodawania  m_LogPrzycisk_dodawanie;
    
    private ActionListener m_LogPrzycisk_1_Listener;
    private ActionListener m_LogPrzycisk_2_Listener;
    private ActionListener m_LogPrzycisk_3_Listener;
    private ActionListener m_LogPrzycisk_4_Listener;
    private ActionListener m_LogPrzycisk_5_Listener;
    private ActionListener m_LogPrzycisk_6_Listener;
    private ActionListener m_LogPrzycisk_7_Listener;
    private ActionListener m_LogPrzycisk_8_Listener;
    private ActionListener m_LogPrzycisk_9_Listener;
    private ActionListener m_LogPrzycisk_0_Listener;
    
    private ActionListener m_LogPrzycisk_oblicz_Listener;
    private ActionListener m_LogPrzycisk_dodawanie_Listener;
    
    class PrzyciskListener implements ActionListener
    {
        PrzyciskListener(IPrzycisk p_przycisk)
        {
            m_przycisk = p_przycisk;
        }
        
        @Override
        public void actionPerformed(ActionEvent p_event)
        {
            m_przycisk.wcisnij();
            m_poleTekstowe.setText("" + m_kalkulator.pobierzWynik());
        }
        IPrzycisk m_przycisk = null;
    }
    
    class Closer extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{
                        m_ramkaGlowna.dispose();
			System.exit(0);
		}
	}
}
