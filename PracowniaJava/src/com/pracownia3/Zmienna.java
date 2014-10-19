package com.pracownia3;

public class Zmienna extends Wyrazenie {
	public Zmienna(String p_idZmiennej) throws RuntimeException
	{
		m_zbior.szukajPary(p_idZmiennej);
		m_idZmiennej = p_idZmiennej;
	}
	
	public Zmienna(String p_idZmiennej, double p_wartosc) throws RuntimeException
	{
		m_zbior.wstaw(p_idZmiennej, p_wartosc);
		m_idZmiennej = p_idZmiennej;
	}
	
	@Override
	public double oblicz()
	{
		return m_zbior.czytaj(m_idZmiennej);
	}
	
	@Override
	public String toString()
	{
		return m_zbior.szukajPary(m_idZmiennej).toString();
	}
	
	private static Zbior m_zbior = new Zbior();
	private String        m_idZmiennej;
}
