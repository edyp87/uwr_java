package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;
import com.google.common.math.BigIntegerMath;

public class PrzyciskSilnia implements IPrzyciskDzialaniaUnarnego
{
    public PrzyciskSilnia(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_argument)
    {
        //TODO :: get rid of int
        return BigIntegerMath.factorial(p_argument.intValue());
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanieUnarne(this);
    }
    
    private Processor m_processor = null;
}
