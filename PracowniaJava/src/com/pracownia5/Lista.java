package com.pracownia5;

public class Lista
{
	public Lista()
	{
		m_poczatek = null;
	}
	
	public void wstaw(Object p_wartosc)
	{
		Wezel l_wezel = new Wezel(null, null, p_wartosc);
		if (isEmpty())
		{
			m_poczatek = l_wezel;
		}
		else
		{
			Wezel l_tmp = m_poczatek;
			while(l_tmp.getNastepny() != null) {}
			
			l_wezel.setPoprzedni(l_tmp);
			l_tmp.setNastepny(l_wezel);
		}
	}
	
	public void wstaw(int p_pozycja, Object p_wartosc)
	{
		Wezel l_wezel = wezelNaPozycji(p_pozycja);
		
		if (l_wezel == null)
		{
			return;
		}
		
		Wezel l_nowyWezel = new Wezel(l_wezel, l_wezel.getNastepny(), p_wartosc);
		l_wezel.getNastepny().setPoprzedni(l_nowyWezel);
		l_wezel.setNastepny(l_nowyWezel);
		
		
	}
	
	public void usun()
	{
		if (isEmpty())
		{
			return;
		}
		Wezel l_tmp = m_poczatek;
		while(l_tmp.getNastepny() != null) {}
		
		l_tmp.getPoprzedni().setNastepny(null);
	}
	
	public void usun(int p_pozycja)
	{
		Wezel l_wezel = wezelNaPozycji(p_pozycja);
		
		if (l_wezel == null)
		{
			return;
		}
		
		
		if (l_wezel.getNastepny() != null)
		{
			l_wezel.getNastepny().setPoprzedni(l_wezel.getPoprzedni());
		}
		if (l_wezel.getPoprzedni() != null)
		{
			l_wezel.getPoprzedni().setNastepny(l_wezel.getNastepny());
		}
	}
	
	public boolean isEmpty()
	{
		return m_poczatek == null;
	}
	
	public Object wartoscNaPozycji(int p_pozycja)
	{
		return wezelNaPozycji(p_pozycja) == null ? 
				null : wezelNaPozycji(p_pozycja).getWartosc();
		
	}
	
	private Wezel wezelNaPozycji(int p_pozycja)
	{
		Wezel l_temp = m_poczatek;
		for(int i = 0; i < p_pozycja; ++i)
		{
			if(l_temp == null) break;
			l_temp = l_temp.getNastepny();
		}
		return l_temp;
	}
	
	Wezel m_poczatek;
}
