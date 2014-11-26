package pracownia6.UI;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import pracownia6.Processor.*;
import pracownia6.Przyciski.*;

public class KalkulatorUI implements IKalkulatorUI
{
    public KalkulatorUI()
    {
        utworzOknoGlowne();
        utworzPoleZWyboremPodstawy();
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
        m_layoutGlowny = new GridBagLayout();
        
        m_panel = new Panel();
        m_panel.setLayout(new GridBagLayout());

        m_ramkaGlowna = new Frame();
        m_ramkaGlowna.add("Center", m_panel);
        m_ramkaGlowna.setBounds(10, 10, 250, 250);
        m_ramkaGlowna.setTitle("Kalkular BigIntegerowy");
        m_ramkaGlowna.addWindowListener(new Closer());
        
        wysrodkujOkno(m_ramkaGlowna);
    }
    
    private void utworzPoleZWyboremPodstawy()
    {      
        m_panelZRadioButtonami = new Panel();
        m_panelZRadioButtonami.setLayout(new GridLayout(1,3));
        m_panelZRadioButtonami.add(m_resultDec);
        m_panelZRadioButtonami.add(m_resultBin);
        m_panelZRadioButtonami.add(m_resultHex);
        
        GridBagConstraints l_constraints = new GridBagConstraints();
        l_constraints.fill = GridBagConstraints.HORIZONTAL;
        l_constraints.gridx = 0;
        l_constraints.gridy = 0;
        
        m_panel.add(m_panelZRadioButtonami, l_constraints);
    }
    
    private void utworzPoleTekstowe()
    {
        m_panelZPolamiTekstowymi = new Panel();
        m_panelZPolamiTekstowymi.setLayout(new GridLayout(1,3));
        
        m_poleTekstoweGlowne = new TextField("0");
        m_poleTekstoweGlowne.setEditable(false);
        
        m_poleTekstoweZOperatorem = new TextField("");
        m_poleTekstoweZOperatorem.setEditable(false);
        
        m_poleTekstowePomocnicze = new TextField("0");
        m_poleTekstowePomocnicze.setEditable(false);
         
        GridBagConstraints l_constraints = new GridBagConstraints();
        
        l_constraints.fill = GridBagConstraints.BOTH;
        l_constraints.gridx = 0;
        l_constraints.gridy = 1;
        
        m_panel.add(m_panelZPolamiTekstowymi, l_constraints);
        m_panelZPolamiTekstowymi.add(m_poleTekstowePomocnicze);
        m_panelZPolamiTekstowymi.add(m_poleTekstoweZOperatorem);
        m_panelZPolamiTekstowymi.add(m_poleTekstoweGlowne);
    }
    
    private void utworzPanelZPrzyciskami()
    {
        m_panelZPrzyciskami = new Panel();
        m_panelZPrzyciskami.setLayout(new GridLayout(6,4));
        
        utworzPrzyciski();
        utworzWarstweLogicznaPrzyciskow();
        dodajPrzyciskiDoPanelu();
        
        GridBagConstraints l_constraints = new GridBagConstraints();
        l_constraints.fill = GridBagConstraints.BOTH;
        l_constraints.weighty = 1.0;
        l_constraints.weightx = 1.0;
        l_constraints.gridx   = 0;
        l_constraints.gridy   = 2;
        
        m_panel.add(m_panelZPrzyciskami, l_constraints);
    }
    
    private void utworzPrzyciski()
    {
        m_przycisk_1  = new Button("1");
        m_przycisk_2  = new Button("2");
        m_przycisk_3  = new Button("3");
        m_przycisk_4  = new Button("4");
        m_przycisk_5  = new Button("5");
        m_przycisk_6  = new Button("6");
        m_przycisk_7  = new Button("7");
        m_przycisk_8  = new Button("8");
        m_przycisk_9  = new Button("9");
        m_przycisk_0  = new Button("0");
        
        m_usunCyfre   = new Button("<-");
        m_modulo      = new Button("%");
        m_dzielenie   = new Button("/");
        m_mnozenie    = new Button("*");
        m_odejmowanie = new Button("-");
        m_dodawanie   = new Button("+");
        m_symbolNewt  = new Button("xCy");
        m_potega      = new Button("^");
        m_oblicz      = new Button("=");
        m_silnia      = new Button("!");
        m_zmianaZnaku = new Button("+/-");
        m_C           = new Button("C");
    }
    
    private void utworzWarstweLogicznaPrzyciskow()
    {
        m_LogPrzycisk_1           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(1));
        m_LogPrzycisk_2           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(2));
        m_LogPrzycisk_3           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(3));
        m_LogPrzycisk_4           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(4));
        m_LogPrzycisk_5           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(5));
        m_LogPrzycisk_6           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(6));
        m_LogPrzycisk_7           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(7));
        m_LogPrzycisk_8           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(8));
        m_LogPrzycisk_9           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(9));
        m_LogPrzycisk_0           = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(0));
        m_LogPrzycisk_oblicz      = new PrzyciskWyniku(m_kalkulator);
        m_LogPrzycisk_dodawanie   = new PrzyciskDodawania(m_kalkulator);
        m_LogPrzycisk_odejmowanie = new PrzyciskOdejmowania(m_kalkulator);
        m_LogPrzycisk_mnozenie    = new PrzyciskMnozenia(m_kalkulator);
        m_LogPrzycisk_dzielenie   = new PrzyciskDzielenia(m_kalkulator);
        m_LogPrzycisk_modulo      = new PrzyciskModulo(m_kalkulator);
        m_LogPrzycisk_potega      = new PrzyciskPotegi(m_kalkulator);
        m_LogPrzycisk_newtona     = new PrzyciskNewtona(m_kalkulator);
        m_LogPrzycisk_silnia      = new PrzyciskSilnia(m_kalkulator);
        m_LogPrzycisk_zmianaZnaku = new PrzyciskZmianyZnaku(m_kalkulator);
        m_LogPrzycisk_usuwanie    = new PrzyciskCofania(m_kalkulator);
        m_LogPrzycisk_C           = new PrzyciskC(m_kalkulator);
        
        powiazPrzyciskiZListenerami();
    }
    
    private void powiazPrzyciskiZListenerami()
    {
        utworzListeneryDlaPrzyciskow();
                
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
        m_odejmowanie.addActionListener(m_LogPrzycisk_odejmowanie_Listener);
        m_mnozenie.addActionListener(m_LogPrzycisk_mnozenie_Listener);
        m_dzielenie.addActionListener(m_LogPrzycisk_dzielenie_Listener);
        m_modulo.addActionListener(m_LogPrzycisk_modulo_Listener);
        m_potega.addActionListener(m_LogPrzycisk_potega_Listener);
        m_symbolNewt.addActionListener(m_LogPrzycisk_newton_Listener);
        m_silnia.addActionListener(m_LogPrzycisk_silnia_Listener);
        m_usunCyfre.addActionListener(m_LogPrzycisk_usuwanie_Listener);
        m_zmianaZnaku.addActionListener(m_LogPrzycisk_zmianaZnaku_Listener);
        m_oblicz.addActionListener(m_LogPrzycisk_oblicz_Listener);
        m_C.addActionListener(m_LogPrzycisk_C_Listener);
        m_resultDec.addItemListener(m_Dec_Listener);
        m_resultBin.addItemListener(m_Bin_Listener);
        m_resultHex.addItemListener(m_Hex_Listener);
    }
    
    private void utworzListeneryDlaPrzyciskow()
    {
        m_LogPrzycisk_1_Listener           = new PrzyciskListener(m_LogPrzycisk_1);
        m_LogPrzycisk_2_Listener           = new PrzyciskListener(m_LogPrzycisk_2);
        m_LogPrzycisk_3_Listener           = new PrzyciskListener(m_LogPrzycisk_3);
        m_LogPrzycisk_4_Listener           = new PrzyciskListener(m_LogPrzycisk_4);
        m_LogPrzycisk_5_Listener           = new PrzyciskListener(m_LogPrzycisk_5);
        m_LogPrzycisk_6_Listener           = new PrzyciskListener(m_LogPrzycisk_6);
        m_LogPrzycisk_7_Listener           = new PrzyciskListener(m_LogPrzycisk_7);
        m_LogPrzycisk_8_Listener           = new PrzyciskListener(m_LogPrzycisk_8);
        m_LogPrzycisk_9_Listener           = new PrzyciskListener(m_LogPrzycisk_9);
        m_LogPrzycisk_0_Listener           = new PrzyciskListener(m_LogPrzycisk_0);
        m_LogPrzycisk_oblicz_Listener      = new PrzyciskListener(m_LogPrzycisk_oblicz);
        m_LogPrzycisk_dodawanie_Listener   = new PrzyciskListener(m_LogPrzycisk_dodawanie);
        m_LogPrzycisk_odejmowanie_Listener = new PrzyciskListener(m_LogPrzycisk_odejmowanie);
        m_LogPrzycisk_mnozenie_Listener    = new PrzyciskListener(m_LogPrzycisk_mnozenie);
        m_LogPrzycisk_dzielenie_Listener   = new PrzyciskListener(m_LogPrzycisk_dzielenie);
        m_LogPrzycisk_potega_Listener      = new PrzyciskListener(m_LogPrzycisk_potega);
        m_LogPrzycisk_modulo_Listener      = new PrzyciskListener(m_LogPrzycisk_modulo);
        m_LogPrzycisk_newton_Listener      = new PrzyciskListener(m_LogPrzycisk_newtona);
        m_LogPrzycisk_silnia_Listener      = new PrzyciskListener(m_LogPrzycisk_silnia);
        m_LogPrzycisk_zmianaZnaku_Listener = new PrzyciskListener(m_LogPrzycisk_zmianaZnaku);
        m_LogPrzycisk_usuwanie_Listener    = new PrzyciskListener(m_LogPrzycisk_usuwanie);
        m_LogPrzycisk_C_Listener           = new PrzyciskListener(m_LogPrzycisk_C);
        m_Dec_Listener                     = new ListenerZmianaPodstawy(m_resultDec, this);
        m_Bin_Listener                     = new ListenerZmianaPodstawy(m_resultBin, this);
        m_Hex_Listener                     = new ListenerZmianaPodstawy(m_resultHex, this);
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
        m_panelZPrzyciskami.add(m_zmianaZnaku);
        m_panelZPrzyciskami.add(m_oblicz);
        m_panelZPrzyciskami.add(m_silnia);
        m_panelZPrzyciskami.add(m_usunCyfre);
        m_panelZPrzyciskami.add(m_C);
    }
    
    private void wysrodkujOkno(Window p_frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()  - p_frame.getWidth())  / 3);
        int y = (int) ((dimension.getHeight() - p_frame.getHeight()) / 3);
        p_frame.setLocation(x, y);
    }
    
    void ustawPodstawe(String p_podstawa)
    {
       if(p_podstawa.equals("Bin"))
       {
           m_konwersja = new KonwertujNaBin();
       }
       else if(p_podstawa.equals("Hex"))
       {
           m_konwersja = new KonwertujNaHex();
       }
       else
       {
           m_konwersja = new KonwertujNaDec();
       }
    }
   
    String konwertuj(BigInteger p_wartosc)
    {
        return m_konwersja.konwertuj(p_wartosc);
    }
    
    BigInteger pobierzWynik()
    {
        return m_kalkulator.pobierzWynik();
    }
    
    BigInteger pobierzZachowanyWynik()
    {
        return m_kalkulator.pobierzZachowanyWynik();
    }
    
    private Panel         m_panel;
    private GridBagLayout m_layoutGlowny;
    private Frame         m_ramkaGlowna;
    TextField             m_poleTekstoweGlowne;
    private TextField     m_poleTekstoweZOperatorem;
    TextField             m_poleTekstowePomocnicze;
    private Panel         m_panelZPolamiTekstowymi;
    private Panel         m_panelZPrzyciskami;
    private Panel         m_panelZRadioButtonami;
    private Button        m_modulo    , m_dzielenie , m_mnozenie  , m_odejmowanie,
                          m_przycisk_7, m_przycisk_8, m_przycisk_9, m_dodawanie  ,
                          m_przycisk_4, m_przycisk_5, m_przycisk_6, m_symbolNewt ,
                          m_przycisk_1, m_przycisk_2, m_przycisk_3, m_potega     ,
                          m_przycisk_0, m_oblicz    , m_usunCyfre , m_silnia     ,
                          m_zmianaZnaku, m_C;

    private Processor          m_kalkulator = new Processor();
    private PrzyciskNumeryczny m_LogPrzycisk_1;
    private PrzyciskNumeryczny m_LogPrzycisk_2;
    private PrzyciskNumeryczny m_LogPrzycisk_3;
    private PrzyciskNumeryczny m_LogPrzycisk_4;
    private PrzyciskNumeryczny m_LogPrzycisk_5;
    private PrzyciskNumeryczny m_LogPrzycisk_6;
    private PrzyciskNumeryczny m_LogPrzycisk_7;
    private PrzyciskNumeryczny m_LogPrzycisk_8;
    private PrzyciskNumeryczny m_LogPrzycisk_9;
    private PrzyciskNumeryczny m_LogPrzycisk_0;
    private PrzyciskWyniku     m_LogPrzycisk_oblicz;
    private PrzyciskDodawania  m_LogPrzycisk_dodawanie;
    private PrzyciskOdejmowania m_LogPrzycisk_odejmowanie;
    private PrzyciskMnozenia   m_LogPrzycisk_mnozenie;
    private PrzyciskDzielenia  m_LogPrzycisk_dzielenie;
    private PrzyciskModulo     m_LogPrzycisk_modulo;
    private PrzyciskPotegi     m_LogPrzycisk_potega;
    private PrzyciskNewtona    m_LogPrzycisk_newtona;
    private PrzyciskSilnia     m_LogPrzycisk_silnia;
    private PrzyciskZmianyZnaku m_LogPrzycisk_zmianaZnaku;
    private PrzyciskCofania    m_LogPrzycisk_usuwanie;
    private PrzyciskC          m_LogPrzycisk_C;
    
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
    private ActionListener m_LogPrzycisk_odejmowanie_Listener;
    private ActionListener m_LogPrzycisk_mnozenie_Listener;
    private ActionListener m_LogPrzycisk_dzielenie_Listener;
    private ActionListener m_LogPrzycisk_modulo_Listener;
    private ActionListener m_LogPrzycisk_potega_Listener;
    private ActionListener m_LogPrzycisk_newton_Listener;
    private ActionListener m_LogPrzycisk_silnia_Listener;
    private ActionListener m_LogPrzycisk_zmianaZnaku_Listener;
    private ActionListener m_LogPrzycisk_usuwanie_Listener;
    private ActionListener m_LogPrzycisk_C_Listener;
    
    private ItemListener m_Dec_Listener, m_Bin_Listener, m_Hex_Listener;
    
    CheckboxGroup IngGrp = new CheckboxGroup();
    Checkbox m_resultDec = new Checkbox("Dec", IngGrp, true);
    Checkbox m_resultBin = new Checkbox("Bin", IngGrp, false);
    Checkbox m_resultHex = new Checkbox("Hex", IngGrp, false);
    
    IKonwertuj m_konwersja = new KonwertujNaDec();
    
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
            m_poleTekstoweGlowne.setText("" + konwertuj(m_kalkulator.pobierzWynik()));
            m_poleTekstoweZOperatorem.setText("" + m_kalkulator.pobierzSymbolAktualnegoDzialaniaBinarnego());
            m_poleTekstowePomocnicze.setText("" + konwertuj(m_kalkulator.pobierzZachowanyWynik()));
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
