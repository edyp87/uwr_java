package tests.pracownia5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia5.Liczba;

public class LiczbaTest
{

	@Test
	public void przechowujeLiczbe()
	{
		Liczba l_liczba = new Liczba(1.1);
		assertEquals(1.1, l_liczba.getLiczba(), 0.001);
	}
}
