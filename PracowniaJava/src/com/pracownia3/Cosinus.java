package com.pracownia3;

public class Cosinus extends Operator1Arg
{
	public Cosinus(Wyrazenie p_argument)
	{
		super(p_argument);
	}

	@Override
	public double oblicz()
	{
		return Math.cos(m_argumentPrawy.oblicz());
	}
	
	@Override
	public String toString()
	{
		return "cos(" + m_argumentPrawy.oblicz() + ")";
	}
}
