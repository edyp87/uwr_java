package pracownia6.wyrazenieZPracowni3;

import java.math.BigInteger;

public class Dziel extends Operator2Arg
{
	public Dziel(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
		okreslOperator();
	}
	
	@Override
	public BigInteger oblicz()
	{
		return m_argumentLewy.oblicz().divide(m_argumentPrawy.oblicz());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "/";
	}

}