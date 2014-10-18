package com.pracownia3;

public class Logarytm extends Operator1Arg
{
	public Logarytm(Wyrazenie p_argument)
	{
		super(p_argument);
	}

	@Override
	public double oblicz()
	{
		return Math.log(m_argumentPrawy.oblicz());
	}
}
