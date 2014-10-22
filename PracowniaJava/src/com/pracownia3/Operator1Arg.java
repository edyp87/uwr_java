package com.pracownia3;

public abstract class Operator1Arg extends Wyrazenie
{
	public Operator1Arg(Wyrazenie p_argument)
	{
		m_argumentPrawy = p_argument;
	}
	
	protected Wyrazenie m_argumentPrawy;
}
