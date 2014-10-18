package com.pracownia3;

public class Odejmij extends Operator2Arg
{
	public Odejmij(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public double oblicz()
	{
		return m_argumentLewy.oblicz() - m_argumentPrawy.oblicz();
	}

}