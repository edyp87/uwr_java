package com.pracownia3;

public class Para
{
	public Para(String p_klucz, double p_wartosc)
	{
		m_klucz   = p_klucz;
		m_wartosc = p_wartosc;
	}
	
	public double getWartosc() {
		return m_wartosc;
	}

	public void setWartosc(double p_wartosc) {
		m_wartosc = p_wartosc;
	}
	
	@Override
	public String toString()
	{
		return "[Klucz: " + m_klucz + "; Wartosc: " + String.valueOf(getWartosc()) + "]";
	}
	
	@Override
	public boolean equals(Object p_wyrazenie)
	{
		if (p_wyrazenie == null)
			return false;
		if (p_wyrazenie == this)
			return true;
		if (!(p_wyrazenie instanceof Para))
			return false;
		
		return this.m_klucz == ((Para)p_wyrazenie).m_klucz;
	}
	
	public final String m_klucz;
	private double      m_wartosc;

}
