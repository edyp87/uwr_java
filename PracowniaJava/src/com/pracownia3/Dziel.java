package com.pracownia3;

public class Dziel extends Operator2Arg
{
	public Dziel(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
		okreslOperator();
	}
	
	@Override
	public double oblicz()
	{
		return m_argumentLewy.oblicz() / m_argumentPrawy.oblicz();
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "/";
	}

}