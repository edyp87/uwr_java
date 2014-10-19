package com.pracownia3;

public class Wieksze extends Operator2Arg
{
	public Wieksze(Wyrazenie p_argumentLewy, Wyrazenie p_argumentPrawy)
	{
		super(p_argumentLewy, p_argumentPrawy);
	}
	
	@Override
	public double oblicz()
	{
		double l_argumentLewy  =  m_argumentLewy.oblicz();
		double l_argumentPrawy = m_argumentPrawy.oblicz();
		
		if (l_argumentLewy > l_argumentPrawy)
		{
			return 1.0;
		}
		else
		{
			return 0.0;
		}
	}
	
	@Override
	protected void okreslOperator()
	{
		m_operator = ">";
	}

}