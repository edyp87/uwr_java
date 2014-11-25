package pracownia6.wyrazenieZPracowni3;

import java.math.BigInteger;

public class Odejmij extends Operator2Arg
{
	public Odejmij(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public BigInteger oblicz()
	{
		return m_argumentLewy.oblicz().subtract(m_argumentPrawy.oblicz());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "-";
	}

}