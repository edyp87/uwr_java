package com.pracownia3;

public class Zbior
{
	public Zbior() {}
	
	public void wstaw(String  p_klucz, double p_wartosc) throws RuntimeException
	{
		if (istniejePara(p_klucz))
		{
			podmienWartosc(p_klucz, p_wartosc);
		}
		else
		{
			sprawdzCzyJestMiejsce();
			dodajElemNaSzczyt(p_klucz, p_wartosc);
		}
	}
	
	public double czytaj(String p_klucz) throws IllegalArgumentException
	{
		if (szukajPary(p_klucz) == null)
		{
			throw new IllegalArgumentException("Para o kluczu " + p_klucz + " nie istnieje!");
		}
		
		return szukajPary(p_klucz).getWartosc();
	}
	
	public void usun(int p_ileElemZostawic) throws IllegalArgumentException
	{	
		sprawdzCzyMoznaUsunac(p_ileElemZostawic);
		usunElemZeSzczytu(p_ileElemZostawic);
	}
	
	public void usun() throws IllegalArgumentException
	{	
		usun(ile()-1);
	}
	
	public int ile()
	{
		return m_iloscElem;
	}
	
	public boolean istniejePara(String  p_klucz)
	{
		if (szukajPary(p_klucz) == null)
		{
			return false;
		}
		return true;
	}
	
	public String toString(String m_idZmiennej)
	{
		return szukajPary(m_idZmiennej).toString();
	}
	
	private void podmienWartosc(String  p_klucz, double p_wartosc)
	{
		szukajPary(p_klucz).setWartosc(p_wartosc);
	}
	
	private Para szukajPary(String p_klucz)
	{
		for (int l_numerPary = 0; l_numerPary < m_iloscElem; ++l_numerPary)
		{
			if (m_pary[l_numerPary].m_klucz == p_klucz)
				return m_pary[l_numerPary];
		}
		return null;
	}
	
	private void sprawdzCzyJestMiejsce() throws RuntimeException
	{
		if (m_iloscElem == m_pojemnoscZbioru)
		{
			throw new RuntimeException("Brak miejsca na stosie!");
		}
	}
	
	private void dodajElemNaSzczyt(String  p_klucz, double p_wartosc)
	{
		m_pary[m_iloscElem++] = new Para(p_klucz, p_wartosc);
	}

	private void sprawdzCzyMoznaUsunac(int p_ileElemZostawic)
	{
		if (p_ileElemZostawic < 0 || p_ileElemZostawic > ile())
		{
			throw new IllegalArgumentException("Nie mozna usunac, argument wykracza poza zakres!");
		}
	}
	
	private void usunElemZeSzczytu(int p_ileElemZostawic)
	{
		m_iloscElem = p_ileElemZostawic;
	}
	
	private int       m_iloscElem       = 0;
	private final int m_pojemnoscZbioru = 100;
	private Para[]    m_pary = new Para[m_pojemnoscZbioru];
}