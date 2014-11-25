package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskMnozenia implements IPrzyciskDzialania
{
    public PrzyciskMnozenia(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        return p_lewyArgument.multiply(p_prawyArgument);
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanie(this);
    }
    
    private Processor m_processor = null;
}
