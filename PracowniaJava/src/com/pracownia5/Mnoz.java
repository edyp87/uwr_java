package com.pracownia5;

public class Mnoz extends Funkcja
{
	@Override
	public double obliczWartosc()
	{
		return m_lewyArgument * m_prawyArgument;
	}

	@Override
	public int arnosc()
	{
		return m_arnosc;
	}

	@Override
	public int brakujaceArgumenty()
	{
		return arnosc() - m_aktualnaLiczbaArg;
	}

	@Override
	public void dodajArgument(double p_arg)
	{
		if (brakujaceArgumenty() == 2)
		{
			m_lewyArgument = p_arg;
		}
		else if (brakujaceArgumenty() == 1)
		{
			m_prawyArgument = p_arg;
		}		
	}
	
	int    m_arnosc = 2;
	int    m_aktualnaLiczbaArg = 0;
	double m_lewyArgument;
	double m_prawyArgument;
}
