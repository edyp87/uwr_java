package tests.pracownia5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia5.Zmienna;

public class ZmiennaTest
{

	@Test
	public void moznaDodacZmienna()
	{
		Zmienna l_zmienna = new Zmienna("ID", 2.1);
		assertEquals(2.1, l_zmienna.getWartosc(), 0.001);
		assertEquals("ID", l_zmienna.getId());
	}

}
