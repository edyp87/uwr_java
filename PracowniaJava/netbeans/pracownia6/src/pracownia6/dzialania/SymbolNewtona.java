package pracownia6.dzialania;

import java.math.BigInteger;
import com.google.common.math.BigIntegerMath;

public class SymbolNewtona extends Operator2Arg
{
	public SymbolNewtona(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public BigInteger oblicz()
	{
		return BigIntegerMath.binomial(
                    m_argumentLewy.oblicz().intValue(), 
                    m_argumentPrawy.oblicz().intValue());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = " po ";
	}
        /*
        private BigInteger obliczDwumianNewtona()
        {
            BigInteger l_return = BigInteger.ONE;
            BigInteger l_left   = m_argumentLewy.oblicz();
            BigInteger l_right  = m_argumentPrawy.oblicz();
            
            for (BigInteger i = BigInteger.ONE; 
                    i.compareTo(l_right) < 0; 
                    i = i.add(BigInteger.ONE))
            {
                l_return = l_return.multiply(
                                l_left.subtract(i))
                                .divide(i.add(BigInteger.ONE));
            }
            return l_return;
        }
*/
}