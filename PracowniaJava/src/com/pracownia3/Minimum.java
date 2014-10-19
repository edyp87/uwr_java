package com.pracownia3;

public class Minimum extends Operator2Arg
{
	public Minimum(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public double oblicz()
	{
		Mniejsze l_mniejsze = new Mniejsze(m_argumentLewy, m_argumentPrawy);
		if (l_mniejsze.oblicz() == 1.0)
		{
			return m_argumentLewy.oblicz();
		}
		else
		{
			return m_argumentPrawy.oblicz();
		}
	}
	
	@Override
	public String toString()
	{
		return "MIN(" + m_argumentLewy.toString() +  m_argumentPrawy.toString() + ")";
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = ",";
	}

}