package pracownia6.dzialania;

import java.math.BigInteger;

public class PrzeciwnyZnak extends Operator1Arg
{
	public PrzeciwnyZnak(Wyrazenie p_argument)
	{
		super(p_argument);
	}

	@Override
	public BigInteger oblicz() {
		return m_argumentPrawy.oblicz().negate();
	}
	
	@Override
	public String toString()
	{
		return "-(" + m_argumentPrawy.oblicz() + ")";
	}
}
