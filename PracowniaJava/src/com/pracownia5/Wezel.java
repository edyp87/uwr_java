package com.pracownia5;

public class Wezel
{
	public Wezel()
	{
		m_poprzedni = null;
		m_nastepny  = null;
		m_wartosc   = null;
	}
	
	public Wezel(Wezel p_poprzedni, Wezel p_nastepny, Object p_wartosc)
	{
		m_poprzedni = p_poprzedni;
		m_nastepny  = p_nastepny;
		m_wartosc   = p_wartosc;
	}
	
	public Wezel getNastepny()
	{
		return m_nastepny;
	}
	
	public Wezel getPoprzedni()
	{
		return m_poprzedni;
	}
	
	public Object getWartosc()
	{
		return m_wartosc;
	}
	
	public void setNastepny(Wezel p_nastepny)
	{
		m_nastepny = p_nastepny;
	}
	
	public void setPoprzedni(Wezel p_poprzedni)
	{
		m_poprzedni = p_poprzedni;
	}
	
	private Wezel  m_poprzedni, m_nastepny;
	private Object m_wartosc;
}
