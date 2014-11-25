package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskNumeryczny implements IPrzycisk
{
    public PrzyciskNumeryczny(Processor p_processor, BigInteger p_wartosc)
    {
        m_wartosc = p_wartosc;
        m_processor = p_processor;
    }
    
    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoNumer(m_wartosc);
    }
    
    private BigInteger m_wartosc;
    private Processor m_processor = null;
}
