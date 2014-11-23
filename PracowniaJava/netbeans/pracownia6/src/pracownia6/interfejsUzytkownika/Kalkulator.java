
package pracownia6.interfejsUzytkownika;

import java.awt.*;

public class Kalkulator extends Panel
{
    public Kalkulator()
    {
        setLayout(new BorderLayout());
        utworzPoleTekstowe();
        utworzPanelZPrzyciskami();
    }
    
    public void wyswietlKalkulator()
    {
        Frame l_ramkaGlowna  = new Frame();
        l_ramkaGlowna.add("Center", this);
        l_ramkaGlowna.setBounds(10, 10, 250, 250);
        wysrodkujOkno(l_ramkaGlowna);
        l_ramkaGlowna.setTitle("Kalkular BigIntegerowy");
        l_ramkaGlowna.setVisible(true);
    }
    
    private void utworzPoleTekstowe()
    {
        m_poleTekstowe = new TextField();
        add("North", m_poleTekstowe);  
    }
    
    private void utworzPanelZPrzyciskami()
    {
        m_panelZPrzyciskami = new Panel();
        m_panelZPrzyciskami.setLayout(new GridLayout(5,4));
        
        utworzPrzyciski();
        dodajPrzyciskiDoPanelu();
        
        add("Center", m_panelZPrzyciskami);
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
    
    public static void wysrodkujOkno(Window p_frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()  - p_frame.getWidth())  / 2);
        int y = (int) ((dimension.getHeight() - p_frame.getHeight()) / 2);
        p_frame.setLocation(x, y);
    }
    
    private TextField m_poleTekstowe;
    private Panel     m_panelZPrzyciskami;
    private Button    m_modulo    , m_dzielenie , m_mnozenie  , m_odejmowanie,
                      m_przycisk_7, m_przycisk_8, m_przycisk_9, m_dodawanie  ,
                      m_przycisk_4, m_przycisk_5, m_przycisk_6, m_symbolNewt ,
                      m_przycisk_1, m_przycisk_2, m_przycisk_3, m_potega     ,
                      m_przycisk_0, m_pusty     , m_oblicz    , m_usunCyfre  ;
}
