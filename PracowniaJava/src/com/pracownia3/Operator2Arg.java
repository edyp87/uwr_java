package com.pracownia3;

public abstract class Operator2Arg extends Operator1Arg
{
	public Operator2Arg(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentPrawy);
		okreslOperator();
		m_argumentLewy = p_argumentLewy;
	}
	
	@Override
	public String toString()
	{
		return "(" + m_argumentLewy.toString() + m_operator + m_argumentPrawy.toString() + ")";
	}
	
	protected abstract void okreslOperator();
	
	protected Wyrazenie m_argumentLewy;
	protected String    m_operator;
}
