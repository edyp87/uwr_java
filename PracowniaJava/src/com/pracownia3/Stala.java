package com.pracownia3;

public class Stala extends Wyrazenie 
{
	public Stala(double l_wartosc)
	{
		m_wartosc = l_wartosc;
	}
	
	@Override
	public double oblicz()
	{
		return m_wartosc;
	}
	
	private double m_wartosc;
}