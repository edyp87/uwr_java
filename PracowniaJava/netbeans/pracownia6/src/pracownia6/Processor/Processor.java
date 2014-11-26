package pracownia6.Processor;

import java.math.BigInteger;
import pracownia6.Przyciski.IPrzyciskDzialaniaBinarnego;
import pracownia6.Przyciski.IPrzyciskDzialaniaUnarnego;

public class Processor
{
    public void wybranoNumer(BigInteger p_wartosc)
    {
        m_aktualnyStan.wybranoNumer(p_wartosc);
        m_wprowadzonoWartosc = true;
    }
    
    public void wybranoDzialanieBinarne(IPrzyciskDzialaniaBinarnego p_dzialanie)
    {
        if(m_wprowadzonoWartosc)
        {
            wykonajPoprzednieDzialanieBinarne();
            zachowajWynik();
        }
        m_przyciskDzialania = p_dzialanie;
        m_aktualnyStan = new StanDzialanie(m_podstawowyStan, this);
    }
    
    public void wybranoDzialanieUnarne(IPrzyciskDzialaniaUnarnego p_dzialanie)
    {
        try
        {
            m_wynik = p_dzialanie.wykonajDzialanie(m_wynik);
            m_aktualnyStan = new StanDzialanieUnarne(m_podstawowyStan, this);
        } 
        catch(Exception e)
        {
            m_pojawilSieWyjatek = true;
        }
    }
    
    public void wykonajPoprzednieDzialanieBinarne()
    {
        try
        {
            m_wynik = m_przyciskDzialania.wykonajDzialanie(m_zachowanyWynik, m_wynik);
        } 
        catch(Exception e)
        {
            m_pojawilSieWyjatek = true;
        }
 
    }
       
    public BigInteger pobierzWynik()
    {
        return m_wynik;
    }
    
    public BigInteger pobierzZachowanyWynik()
    {
        return m_zachowanyWynik;
    }
    
    public String pobierzSymbolAktualnegoDzialaniaBinarnego()
    {
        String l_returnValue = m_przyciskDzialania.toString();
        if (m_pojawilSieWyjatek)
        {
            l_returnValue =  "Wyjatek!";
            m_pojawilSieWyjatek = false; 
            resetujProcessor();
        }
        return l_returnValue;
    }
        
    public void aktualizujWynik(BigInteger p_wartosc)
    {
        m_wynik = p_wartosc;
    }
    
    public void zachowajWynik()
    {
        m_zachowanyWynik = m_wynik;
        m_wynik          = BigInteger.ZERO;
        m_wprowadzonoWartosc = false;
    }
    
    public void resetujProcessor()
    {
        m_wynik             = BigInteger.ZERO;
        m_zachowanyWynik    = BigInteger.ZERO;
        m_przyciskDzialania = m_pusteDzialanie;
        resetujStan();
    }
    
    public void resetujStan()
    {
        m_aktualnyStan = m_podstawowyStan;
    }
    
    private IStan              m_podstawowyStan    = new StanLiczba(this);
    private IStan              m_aktualnyStan      = m_podstawowyStan;
    private BigInteger         m_wynik             = BigInteger.ZERO;
    private BigInteger         m_zachowanyWynik    = BigInteger.ZERO;
    private IPrzyciskDzialaniaBinarnego m_pusteDzialanie = new NullOperator();
    private IPrzyciskDzialaniaBinarnego m_przyciskDzialania = m_pusteDzialanie;
    private boolean m_pojawilSieWyjatek = false;
    private boolean m_wprowadzonoWartosc = false;
    
    public class NullOperator implements IPrzyciskDzialaniaBinarnego
    {
        @Override
        public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
        {
            return pobierzWynik();
        }

        @Override
        public void wcisnij()
        {
        }
        
        @Override
        public String toString()
        {
            return "";
        }
        
    }
}
