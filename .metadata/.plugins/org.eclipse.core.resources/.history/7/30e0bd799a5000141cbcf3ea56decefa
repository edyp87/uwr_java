package com.pracownia2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TrojkatPascalaTest {
	
	int m_wiersz = 0;
	final int m_pierwszaKolumna = 0;
	@Test
	public void zwracaJedenDlaPierwszegoWiersza()
	{
		m_wiersz = 0;
		assertEquals(1, TrojkatPascala.czytaj(m_wiersz,0));
		
	}
	
	@Test
	public void zwracaJedenDlaDrugiegoWiersza() {
		m_wiersz = 1;
		for(int l_kolumna = m_pierwszaKolumna; l_kolumna < m_wiersz+1; ++l_kolumna)
		{
			assertEquals(1, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
		}
	}
	
	@Test
	public void zwracaWartosciDlaTrzeciegoWiersza() {
		m_wiersz = 2;
		for(int l_kolumna = m_pierwszaKolumna; l_kolumna < m_wiersz+1; ++l_kolumna)
		{
			if(l_kolumna == 1)
			{
				assertEquals(2, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
			}
			else
			{
				assertEquals(1, TrojkatPascala.czytaj(m_wiersz, l_kolumna));
			}
		}
	}
}
