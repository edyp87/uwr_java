package pracownia6.wyrazenieZPracowni3;

import java.math.BigInteger;

public class Mnoz extends Operator2Arg
{
	public Mnoz(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public BigInteger oblicz()
	{
		return m_argumentLewy.oblicz().multiply(m_argumentPrawy.oblicz());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "*";
	}

}