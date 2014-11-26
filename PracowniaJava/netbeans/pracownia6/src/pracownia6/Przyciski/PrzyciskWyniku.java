package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskWyniku implements IPrzyciskDzialaniaUnarnego
{
    public PrzyciskWyniku(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_argument)
    {
        m_processor.wykonajPoprzednieDzialanieBinarne();
        m_processor.zachowajWynik();
        m_processor.pobierzWynik();
        return m_processor.pobierzWynik();
    }

    @Override
    public void wcisnij()
    {
        m_processor.wybranoDzialanieUnarne(this);
    }
    
    private Processor m_processor = null;
}
