package com.pracownia3;

public class FunWykladnicza extends Operator2Arg
{
	public FunWykladnicza(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public double oblicz()
	{
		return Math.pow(m_argumentLewy.oblicz(), m_argumentPrawy.oblicz());
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = "^";
	}

}