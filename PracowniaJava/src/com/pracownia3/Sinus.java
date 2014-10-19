package com.pracownia3;

public class Sinus extends Operator1Arg
{
	public Sinus(Wyrazenie p_argument)
	{
		super(p_argument);
	}

	@Override
	public double oblicz()
	{
		return Math.sin(m_argumentPrawy.oblicz());
	}
	
	@Override
	public String toString()
	{
		return "sin(" + m_argumentPrawy.oblicz() + ")";
	}
}
