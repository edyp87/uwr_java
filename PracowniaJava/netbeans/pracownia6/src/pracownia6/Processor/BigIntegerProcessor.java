package pracownia6.Processor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import pracownia6.wyrazenieZPracowni3.*;

public class BigIntegerProcessor implements ActionListener
{
    public BigIntegerProcessor()
    {
        m_wynik = BigInteger.ONE;
    }
    
    public String pobierzWynik()
    {
        return m_wynik.toString();
    }

    public void ustawWynik(String p_wynik)
    {
        m_wynik = new BigInteger(p_wynik);
    }

    public void dodaj(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        Wyrazenie l_prawy = new Stala(new BigInteger(p_argument));
        m_wynik = (new Dodaj(l_lewy, l_prawy)).oblicz();
    }

    public void odejmij(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        Wyrazenie l_prawy = new Stala(new BigInteger(p_argument));
        m_wynik = (new Odejmij(l_lewy, l_prawy)).oblicz();
    }

    public void pomnoz(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        Wyrazenie l_prawy = new Stala(new BigInteger(p_argument));
        m_wynik = (new Mnoz(l_lewy, l_prawy)).oblicz();
    }

    public void podziel(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        Wyrazenie l_prawy = new Stala(new BigInteger(p_argument));
        m_wynik = (new Dziel(l_lewy, l_prawy)).oblicz();
    }

    public void silnia()
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        m_wynik = (new Silnia(l_lewy)).oblicz();
    }

    public void symbolNewtona(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        m_wynik = (new Silnia(l_lewy)).oblicz();
    }

    public void potega(String p_argument)
    {
        Wyrazenie l_lewy  = new Stala(m_wynik);
        Wyrazenie l_prawy = new Stala(new BigInteger(p_argument));
        m_wynik = (new Potega(l_lewy, l_prawy)).oblicz();
    }
    
    BigInteger m_wynik;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String l_przycisk = e.getActionCommand();
        if(l_przycisk.equals("1"))
        {
            
        }
    }
}
/*
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
        m_oblicz     = new Button("=");*/