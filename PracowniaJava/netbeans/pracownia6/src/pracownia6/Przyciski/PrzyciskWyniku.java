package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskWyniku implements IPrzycisk
{
    public PrzyciskWyniku(Processor p_processor)
    {
        m_processor = p_processor;
    }

    @Override
    public void wcisnij()
    {
        m_processor.wykonajDzialanie();
        BigInteger p_wynik = m_processor.pobierzWynik();
        m_processor.resetujProcessor();
        m_processor.aktualizujWynik(p_wynik);
        
    }
    
    private Processor m_processor = null;
}
