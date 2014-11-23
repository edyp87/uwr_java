package com.pracownia5;

public class Kolejka extends Lista
{
	public void enqueue(Object p_wartosc)
	{
		wstaw(0, p_wartosc);
	}
	
	public Object dequeue()
	{
		if (isEmpty())
		{
			return null;
		}
		
		Object l_temp = m_poczatek.getWartosc();
		
		m_poczatek.getNastepny().setPoprzedni(null);
		m_poczatek = m_poczatek.getNastepny();
		
		return l_temp;
	}
}
