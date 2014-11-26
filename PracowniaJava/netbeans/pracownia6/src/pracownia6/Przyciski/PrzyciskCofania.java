package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskCofania implements IPrzyciskDzialaniaUnarnego
{
    public PrzyciskCofania(Processor p_processor)
    {
        m_processor = p_processor;
    }
    
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_argument)
    {
        BigInteger l_wartosc = (m_processor.pobierzWynik().divide(new BigInteger("10")));
        return l_wartosc;
    }
    
    @Override
    public void wcisnij()
    {
        m_processor.wybranoDzialanieUnarne(this);
    }
    
    private Processor m_processor = null;
}
