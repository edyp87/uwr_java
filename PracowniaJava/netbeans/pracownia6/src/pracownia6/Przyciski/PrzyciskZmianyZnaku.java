package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;
import com.google.common.math.BigIntegerMath;

public class PrzyciskZmianyZnaku implements IPrzyciskDzialaniaUnarnego
{
    public PrzyciskZmianyZnaku(Processor p_processor)
    {
        m_processor = p_processor;
    }
        
    @Override
    public BigInteger wykonajDzialanie(BigInteger p_argument)
    {
        //TODO :: get rid of int
        return p_argument.negate();
    }

    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoDzialanieUnarne(this);
    }
    
    private Processor m_processor = null;
}
