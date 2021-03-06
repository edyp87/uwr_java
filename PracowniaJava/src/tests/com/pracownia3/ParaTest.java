package tests.com.pracownia3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia3.Para;

public class ParaTest
{
	@Test
	public void getterZwracaWartosc()
	{
		double l_wartosc = 1.2;
		Para l_para = new Para("klucz", l_wartosc);
		assertEquals(l_wartosc, l_para.getWartosc(), m_deltaDlaAsercji);
	}
	
	@Test
	public void setterUstawiaWartosc()
	{
		double l_wartosc1 = 1.2;
		double l_wartosc2 = 2.1;
		Para l_para = new Para("klucz", l_wartosc1);
		assertEquals(l_wartosc1, l_para.getWartosc(), m_deltaDlaAsercji);
		l_para.setWartosc(l_wartosc2);
		assertEquals(l_wartosc2, l_para.getWartosc(), m_deltaDlaAsercji);
	}
	
	@Test
	public void potrafiDrukowacStringaZZawartosci()
	{
		double l_wartosc = 1.2;
		Para l_para = new Para("klucz", l_wartosc);
		assertEquals("[Klucz: klucz; Wartosc: 1.2]", l_para.toString());
	}
	
	@Test
	public void potrafiPorownywac()
	{
		double l_wartosc = 1.2;
		Para l_para1 = new Para("klucz",     l_wartosc);
		Para l_para2 = new Para("klucz",     l_wartosc + 1);
		Para l_para3 = new Para("nowyKlucz", l_wartosc);
		assertTrue (l_para1.equals(l_para1));
		assertTrue (l_para1.equals(l_para2));
		assertFalse(l_para1.equals(l_para3));
		assertFalse(l_para2.equals(l_para3));	
	}
	
	private final double m_deltaDlaAsercji = 0.001;
	
}
