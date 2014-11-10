package tests.com.narzedzia;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import narzedzia.Para;

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
		
		final char   c_inversedExclamationMark = '\u00A1';
		final char   c_inversedQuestionMark    = '\u00BF';
		final String c_separator               = ": ";
		final String c_returnedValue = c_inversedExclamationMark 
				+ "klucz" 
				+ c_separator 
				+ String.valueOf(l_wartosc) 
				+ c_inversedQuestionMark;
		
		assertEquals(c_returnedValue, l_para.toString());
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
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void zwracaWyjatekGdyWartoscJestZerowa()
	{
		exception.expect(IllegalArgumentException.class);
		new Para("ident", 0);
	}
	
	@Test
	public void zwracaWyjatekGdyWartoscJestUjemna()
	{
		exception.expect(IllegalArgumentException.class);
		new Para("ident", -1);
	}
	
	@Test
	public void zwracaWyjatekGdyIdentyfikatorNieJestJavovy()
	{
		exception.expect(IllegalArgumentException.class);
		new Para("4ident", 1);
	}
	
	@Test
	public void pareMoznaKlonowac() throws CloneNotSupportedException
	{
		
		Para l_para1 = new Para("ident", 1);
		Para l_para2 = (Para) l_para1.clone();
		l_para2.setWartosc(2);
		assertEquals(1, l_para1.getWartosc(), m_deltaDlaAsercji);	
		assertEquals(2, l_para2.getWartosc(), m_deltaDlaAsercji);
		assertEquals("ident", l_para1.m_klucz);	
		assertEquals("ident", l_para2.m_klucz);	
	}
	
	@Test
	public void pareMoznaKomparowac() 
	{
		
		Para l_paraRef      = new Para("b", 1);
		Para l_paraRowna    = new Para("b", 1);
		Para l_paraMniejsza = new Para("a", 1);
		Para l_paraWieksza  = new Para("c", 1);
		
		assertEquals(0, l_paraRef.compareTo(l_paraRowna));
		assertTrue(l_paraRef.compareTo(l_paraMniejsza) > 0);
		assertTrue(l_paraRef.compareTo(l_paraWieksza ) < 0);	
	}
	
	private final double m_deltaDlaAsercji = 0.001;
	
}
