package com.pracownia5;

public class Liczba extends Operand
{
	public Liczba (double p_liczba)
	{
		m_liczba = p_liczba;
	}
	
	public double getLiczba()
	{
		return m_liczba;
	}
	
	private double m_liczba;

	@Override
	public double obliczWartosc()
	{
		return m_liczba;
	}
}
