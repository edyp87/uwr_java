package pracownia6.Processor;

import java.math.BigInteger;
import pracownia6.Przyciski.IPrzyciskDzialaniaBinarnego;
import pracownia6.Przyciski.IPrzyciskDzialaniaUnarnego;

public class Processor
{
    public void wcisnietoNumer(BigInteger p_wartosc)
    {
        m_aktualnyStan.wprowadz(p_wartosc);
    }
    
    public void wcisnietoDzialanieBinarne(IPrzyciskDzialaniaBinarnego p_dzialanie)
    {
        wykonajDzialanie();
        m_przyciskDzialania = p_dzialanie;
        m_aktualnyStan = new StanDzialanie(m_podstawowyStan, this);
        zachowajWynik();
    }
    
    public void wcisnietoDzialanieUnarne(IPrzyciskDzialaniaUnarnego p_dzialanie)
    {
        m_wynik = p_dzialanie.wykonajDzialanie(m_wynik);
    }
    
    public void wykonajDzialanie()
    {
        m_wynik = m_przyciskDzialania.wykonajDzialanie(m_zachowanyWynik, m_wynik);
    }
       
    public BigInteger pobierzWynik()
    {
        return m_wynik;
    }
    
    public BigInteger pobierzZachowanyWynik()
    {
        return m_zachowanyWynik;
    }
    
    public String pobierzSymbolDzialaniaBinarnego()
    {
        return m_przyciskDzialania.toString();
    }
        
    public void aktualizujWynik(BigInteger p_wartosc)
    {
        m_wynik = p_wartosc;
    }
    
    public void zachowajWynik()
    {
        m_zachowanyWynik = m_wynik;
        m_wynik          = BigInteger.ZERO;
    }
    
    public void resetujProcessor()
    {
        m_wynik             = BigInteger.ZERO;
        m_zachowanyWynik    = BigInteger.ZERO;
        m_przyciskDzialania = new NullOperator();
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
    private IPrzyciskDzialaniaBinarnego m_przyciskDzialania = new NullOperator();
    
    private class NullOperator implements IPrzyciskDzialaniaBinarnego
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
