package pracownia6.wyrazenieZPracowni3;

import java.math.BigInteger;

public class Silnia extends Operator1Arg
{
	public Silnia(Wyrazenie p_argument)
	{
                    super(p_argument);
	}

	@Override
	public BigInteger oblicz() {
            return obliczSilnie();
	}
	
	@Override
	public String toString()
	{
            return m_argumentPrawy.oblicz() + "!";
	}
        
        private BigInteger obliczSilnie()
        {
            BigInteger l_result = BigInteger.ONE;
            BigInteger l_temp   = m_argumentPrawy.oblicz();
            while (!l_temp.equals(BigInteger.ZERO))
            {
                l_result = l_result.multiply(l_temp);
                l_temp = (new Odejmij(new Stala(l_temp), new Stala(BigInteger.ONE))).oblicz();
            }
            return l_result;
        }
}
