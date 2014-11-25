package pracownia6.Processor;

import java.math.BigInteger;

public class StanLiczba implements IStan
{
    StanLiczba(Processor p_processor)
    {
        m_processor = p_processor;
    }
    
    @Override
    public void wprowadz(BigInteger p_wartosc)
    {
        BigInteger l_wartosc = (m_processor.pobierzWynik().multiply(new BigInteger("10"))).add(p_wartosc);
        m_processor.aktualizujWynik(l_wartosc);
    }
    
    private Processor m_processor = null;
}
