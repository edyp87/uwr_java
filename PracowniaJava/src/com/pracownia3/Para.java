package com.pracownia3;

public class Para {
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
	
	public String toString()
	{
		return "[Klucz: " + m_klucz + "; Wartosc: " + String.valueOf(getWartosc()) + "]";
	}
	
	public boolean equals(Para p_para)
	{
		return this.m_klucz == p_para.m_klucz;
	}
	
	public final String m_klucz;
	private double      m_wartosc;

}
