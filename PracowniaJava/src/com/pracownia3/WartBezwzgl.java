package com.pracownia3;

public class WartBezwzgl extends Operator1Arg
{
	public WartBezwzgl(Wyrazenie p_argument)
	{
		super(p_argument);
	}
	
	@Override
	public double oblicz()
	{
		return Math.abs(m_argumentPrawy.oblicz());
	}
	
	@Override
	public String toString()
	{
		return "|" + m_argumentPrawy.oblicz() + "|";
	}
}
