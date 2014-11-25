package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskOdejmowania implements IPrzyciskDzialania
{
    public PrzyciskOdejmowania(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        return p_lewyArgument.subtract(p_prawyArgument);
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanie(this);
    }
    
    private Processor m_processor = null;
}
