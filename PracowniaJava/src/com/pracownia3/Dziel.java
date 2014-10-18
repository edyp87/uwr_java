package com.pracownia3;

public class Dziel extends Operator2Arg
{
	public Dziel(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public double oblicz()
	{
		return m_argumentLewy.oblicz() / m_argumentPrawy.oblicz();
	}

}