package pracownia6.Przyciski;

import java.math.BigInteger;
import pracownia6.Processor.Processor;

public class PrzyciskCofania implements IPrzycisk
{
    public PrzyciskCofania(Processor p_processor, BigInteger p_wartosc)
    {
        m_wartosc = p_wartosc;
        m_processor = p_processor;
    }

    public BigInteger cofnijLiczbe(BigInteger p_lewyArgument, BigInteger p_prawyArgument)
    {
        return p_lewyArgument.add(p_prawyArgument);
    }
    
    @Override
    public void wcisnij()
    {
        m_processor.wcisnietoCofnij();
    }
    
    private BigInteger m_wartosc;
    private Processor m_processor = null;
}
