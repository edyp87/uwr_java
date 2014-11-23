package pracownia6.dzialania;

import java.math.BigInteger;

public class Potega extends Operator2Arg
{
	public Potega(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public BigInteger oblicz()
	{
		return pow(m_argumentLewy.oblicz(), m_argumentPrawy.oblicz());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "^";
	}
        
        private BigInteger pow(BigInteger p_base, BigInteger p_exp)
        {
            BigInteger l_result = BigInteger.ONE;
            
            
            while (p_exp.signum() > 0)
            {
                if (p_exp.testBit(0))
                {
                    l_result = l_result.multiply(p_base);
                }
                p_base = p_base.multiply(p_base);
                p_exp = p_exp.shiftRight(1);
            }
            return l_result;
        }

}