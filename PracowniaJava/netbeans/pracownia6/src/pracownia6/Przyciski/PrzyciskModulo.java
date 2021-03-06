package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskModulo implements IPrzyciskDzialaniaBinarnego
{
    public PrzyciskModulo(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        return p_lewyArgument.mod(p_prawyArgument);
    }

    @Override
    public void wcisnij()
    {
        m_processor.wybranoDzialanieBinarne(this);
    }
    
    @Override
    public String toString()
    {
        return "%";
    }
    
    private Processor m_processor = null;
}
