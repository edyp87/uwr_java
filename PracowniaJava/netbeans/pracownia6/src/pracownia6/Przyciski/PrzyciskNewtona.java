package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;
import com.google.common.math.BigIntegerMath;

public class PrzyciskNewtona implements IPrzyciskDzialaniaBinarnego
{
    public PrzyciskNewtona(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument) throws Exception
    {
        return BigIntegerMath.binomial(
                    p_lewyArgument.intValue(), 
                    p_prawyArgument.intValue());
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanieBinarne(this);
    }
    
    @Override
    public String toString()
    {
        return "xCy";
    }
    
    private Processor m_processor = null;
}
