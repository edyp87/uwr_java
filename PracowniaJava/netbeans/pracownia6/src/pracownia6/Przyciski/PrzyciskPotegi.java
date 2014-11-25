package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskPotegi implements IPrzyciskDzialaniaBinarnego
{
    public PrzyciskPotegi(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        // TODO - za duza potega
        return p_lewyArgument.pow(p_prawyArgument.intValue());
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanieBinarne(this);
    }
    
    @Override
    public String toString()
    {
        return "^";
    }
    
    private Processor m_processor = null;
}
