package com.pracownia5;

public class Stos extends Lista
{
	public void push(Object p_wartosc)
	{
		wstaw(p_wartosc);
	}
	
	public Object pop()
	{
		if (isEmpty())
		{
			return null;
		}
		
		Wezel l_temp = m_poczatek;
		
		while(l_temp.getNastepny() != null) {}
		
		l_temp.getPoprzedni().setNastepny(null);
		
		return l_temp.getWartosc();
	}
}
