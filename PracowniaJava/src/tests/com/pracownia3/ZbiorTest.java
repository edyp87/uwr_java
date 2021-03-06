package tests.com.pracownia3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pracownia3.Zbior;

public class ZbiorTest 
{
	@Test
	public void dodajeNowyElement() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc = 1.2;
		
		l_zbior.wstaw("klucz", l_wartosc);
		assertEquals(l_wartosc, l_zbior.czytaj("klucz"), m_deltaDlaAsercji);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void ZwracaWyjatekGdyKluczNieIstnieje() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc = 1.2;
		
		l_zbior.wstaw("klucz", l_wartosc);
		exception.expect( IllegalArgumentException.class );
		l_zbior.czytaj("klucz" + "COS");
	}
	
	@Test
	public void dodajeDwaElementy() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc1 = 1.1;
		double l_wartosc2 = 1.2;
		
		l_zbior.wstaw("klucz1", l_wartosc1);
		l_zbior.wstaw("klucz2", l_wartosc2);
		assertEquals(l_wartosc1, l_zbior.czytaj("klucz1"), m_deltaDlaAsercji);
		assertEquals(l_wartosc2, l_zbior.czytaj("klucz2"), m_deltaDlaAsercji);
	}
	
	@Test
	public void zwracaIloscElementowWZbiorze() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc1 = 1.1;
		double l_wartosc2 = 1.2;
		
		l_zbior.wstaw("klucz1", l_wartosc1);
		assertEquals(1, l_zbior.ile());
		l_zbior.wstaw("klucz2", l_wartosc2);
		assertEquals(2, l_zbior.ile());
	}
	
	@Test
	public void usuwaDwaElementyPozostawiaJeden() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc1 = 1.1;
		double l_wartosc2 = 1.2;
		double l_wartosc3 = 1.3;
		
		l_zbior.wstaw("klucz1", l_wartosc1);
		l_zbior.wstaw("klucz2", l_wartosc2);
		l_zbior.wstaw("klucz3", l_wartosc3);
		assertEquals(l_wartosc1, l_zbior.czytaj("klucz1"), m_deltaDlaAsercji);
		assertEquals(l_wartosc2, l_zbior.czytaj("klucz2"), m_deltaDlaAsercji);
		assertEquals(l_wartosc3, l_zbior.czytaj("klucz3"), m_deltaDlaAsercji);
		assertEquals(3, l_zbior.ile());
		l_zbior.usun(1);
		assertEquals(l_wartosc1, l_zbior.czytaj("klucz1"), m_deltaDlaAsercji);
		assertEquals(1, l_zbior.ile());
		exception.expect( IllegalArgumentException.class );
		l_zbior.czytaj("klucz2");
	}
	
	@Test
	public void zwracaWyjatekGdyChcemyUsunacZbytDuzoElem()
	{
		Zbior l_zbior = new Zbior();

		exception.expect( IllegalArgumentException.class );
		l_zbior.usun(2000);
	}
	
	@Test
	public void zwracaWyjatekGdyChcemyUsunacUjemnaIloscElem()
	{
		Zbior l_zbior = new Zbior();

		exception.expect( IllegalArgumentException.class );
		l_zbior.usun(-1);
	}
	
	@Test
	public void usuwaElementZeSzczytuZbioru() throws RuntimeException
	{
		Zbior l_zbior = new Zbior();
		double l_wartosc1 = 1.1;
		double l_wartosc2 = 1.2;
		double l_wartosc3 = 1.3;
		
		l_zbior.wstaw("klucz1", l_wartosc1);
		l_zbior.wstaw("klucz2", l_wartosc2);
		l_zbior.wstaw("klucz3", l_wartosc3);
		assertEquals(l_wartosc1, l_zbior.czytaj("klucz1"), m_deltaDlaAsercji);
		assertEquals(l_wartosc2, l_zbior.czytaj("klucz2"), m_deltaDlaAsercji);
		assertEquals(l_wartosc3, l_zbior.czytaj("klucz3"), m_deltaDlaAsercji);
		assertEquals(3, l_zbior.ile());
		l_zbior.usun();
		assertEquals(l_wartosc1, l_zbior.czytaj("klucz1"), m_deltaDlaAsercji);
		assertEquals(2, l_zbior.ile());
		exception.expect( IllegalArgumentException.class );
		l_zbior.czytaj("klucz3");
	}
	
	private final double m_deltaDlaAsercji = 0.001;
}
