package pracownia6.Processor;

import java.math.BigInteger;

public class StanDzialanie implements IStan
{
    public StanDzialanie(IStan p_przetwarzanieLiczb, Processor p_processor)
    {
        m_przetwarzanieLiczb = p_przetwarzanieLiczb;
        m_processor = p_processor;
    }
    @Override
    public void wybranoNumer(BigInteger p_wartosc)
    {
        m_przetwarzanieLiczb.wybranoNumer(p_wartosc);
        m_processor.resetujStan();
    }
    
    private IStan m_przetwarzanieLiczb = null;
    private Processor m_processor = null;
}
