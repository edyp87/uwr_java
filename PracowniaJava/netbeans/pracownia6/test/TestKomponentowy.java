/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigInteger;
import pracownia6.Processor.Processor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pracownia6.Przyciski.*;

/**
 *
 * @author marek
 */
public class TestKomponentowy {
    
    @Test
    public void moznaUtworzycProcessor()
    {
        Processor m_kalkulator1 = new Processor();
    }
        
    @Test
    public void moznaWprowadzicWartosc()
    {
        m_numer1.wcisnij();
        m_numer1.wcisnij();
        m_numer2.wcisnij();
        m_numer3.wcisnij();
        m_numer4.wcisnij();
        m_numer5.wcisnij();
        m_numer6.wcisnij();
        m_numer7.wcisnij();
        m_numer8.wcisnij();
        m_numer9.wcisnij();
        m_numer0.wcisnij();
        assertEquals(new BigInteger("11234567890"), m_kalkulator.pobierzWynik()); 
    }
        
    @Test
    public void moznaDodawacWartosci()
    {
        m_numer1.wcisnij();
        m_dodawanie.wcisnij();
        m_numer2.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("3"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaOdejmowacWartosci()
    {
        m_numer1.wcisnij();
        m_odejmowanie.wcisnij();
        m_numer2.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("-1"), m_kalkulator.pobierzWynik()); 
    }
    
        
    @Test
    public void moznaMnozycWartosci()
    {
        m_numer2.wcisnij();
        m_mnozenie.wcisnij();
        m_numer3.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("6"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaDzielicWartosci()
    {
        m_numer6.wcisnij();
        m_dzielenie.wcisnij();
        m_numer2.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("3"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaDzielicModuloWartosci()
    {
        m_numer6.wcisnij();
        m_mod.wcisnij();
        m_numer4.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("2"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaPodnosicDoPotegi()
    {
        m_numer6.wcisnij();
        m_potega.wcisnij();
        m_numer4.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("1296"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaLiczycDwumianNewtona()
    {
        m_numer8.wcisnij();
        m_numer1.wcisnij();
        m_newton.wcisnij();
        m_numer2.wcisnij();
        m_numer5.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("525652003943603702568"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaLiczycSilnie()
    {
        m_numer6.wcisnij();
        m_silnia.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("720"), m_kalkulator.pobierzWynik()); 
    }
        
    @Test
    public void moznaZmieniacZnak()
    {
        m_numer6.wcisnij();
        m_numer2.wcisnij();
        m_zmianaZnaku.wcisnij();
        m_wynik.wcisnij();
        assertEquals(new BigInteger("-62"), m_kalkulator.pobierzWynik()); 
    }
    
    @Test
    public void moznaUsuwacWprowadzoneLiczby()
    {
        m_numer1.wcisnij();
        m_numer1.wcisnij();
        m_numer2.wcisnij();
        m_numer3.wcisnij();
        m_numer4.wcisnij();
        m_numer5.wcisnij();
        m_numer6.wcisnij();
        m_numer7.wcisnij();
        m_numer8.wcisnij();
        m_numer9.wcisnij();
        m_numer0.wcisnij();
        m_cofanie.wcisnij();
        m_cofanie.wcisnij();
        m_cofanie.wcisnij();
        m_cofanie.wcisnij();
        assertEquals(new BigInteger("1123456"), m_kalkulator.pobierzWynik()); 
    }
    
    
    @Before
    public void setUp()
    {
        m_kalkulator = new Processor();
        m_numer1 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(1));
        m_numer2 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(2));
        m_numer3 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(3));
        m_numer4 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(4));
        m_numer5 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(5));
        m_numer6 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(6));
        m_numer7 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(7));
        m_numer8 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(8));
        m_numer9 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(9));
        m_numer0 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(0));  
        m_dodawanie = new PrzyciskDodawania(m_kalkulator);
        m_wynik = new PrzyciskWyniku(m_kalkulator);
        m_cofanie = new PrzyciskCofania(m_kalkulator);
        m_odejmowanie = new PrzyciskOdejmowania(m_kalkulator);
        m_mnozenie = new PrzyciskMnozenia(m_kalkulator);
        m_dzielenie = new PrzyciskDzielenia(m_kalkulator);
        m_mod = new PrzyciskModulo(m_kalkulator);
        m_potega = new PrzyciskPotegi(m_kalkulator);
        m_newton = new PrzyciskNewtona(m_kalkulator);
        m_silnia = new PrzyciskSilnia(m_kalkulator);
        m_zmianaZnaku = new PrzyciskZmianyZnaku(m_kalkulator);
    }
        
        Processor m_kalkulator = new Processor();
        PrzyciskNumeryczny m_numer1 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(1));
        PrzyciskNumeryczny m_numer2 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(2));
        PrzyciskNumeryczny m_numer3 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(3));
        PrzyciskNumeryczny m_numer4 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(4));
        PrzyciskNumeryczny m_numer5 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(5));
        PrzyciskNumeryczny m_numer6 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(6));
        PrzyciskNumeryczny m_numer7 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(7));
        PrzyciskNumeryczny m_numer8 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(8));
        PrzyciskNumeryczny m_numer9 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(9));
        PrzyciskNumeryczny m_numer0 = new PrzyciskNumeryczny(m_kalkulator, BigInteger.valueOf(0));  
        PrzyciskDodawania  m_dodawanie = new PrzyciskDodawania(m_kalkulator);
        PrzyciskWyniku     m_wynik = new PrzyciskWyniku(m_kalkulator);
        PrzyciskCofania     m_cofanie;
        PrzyciskOdejmowania m_odejmowanie;
        PrzyciskMnozenia m_mnozenie;
        PrzyciskDzielenia m_dzielenie;
        PrzyciskModulo m_mod;
        PrzyciskPotegi m_potega;
        PrzyciskNewtona m_newton;
        PrzyciskSilnia m_silnia;
        PrzyciskZmianyZnaku m_zmianaZnaku;
}
