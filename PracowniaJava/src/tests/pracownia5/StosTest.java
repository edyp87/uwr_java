package tests.pracownia5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia3.Para;
import com.pracownia5.Stos;

public class StosTest {

	@Test
	public void test()
	{
		Stos l_stos = new Stos();
		
		l_stos.push(new Para("ID1", 0));
		l_stos.push(new Para("ID2", 1));
		l_stos.push(new Para("ID3", 2));
		l_stos.push(new Para("ID4", 3));
		l_stos.push(new Para("ID5", 4));
		l_stos.push(new Para("ID6", 5));
		
		assertEquals(5, ((Para) l_stos.pop()).getWartosc(), 0.001);
		assertEquals(4, ((Para) l_stos.pop()).getWartosc(), 0.001);
		assertEquals(3, ((Para) l_stos.pop()).getWartosc(), 0.001);
		assertEquals(2, ((Para) l_stos.pop()).getWartosc(), 0.001);
		assertEquals(1, ((Para) l_stos.pop()).getWartosc(), 0.001);
		assertEquals(0, ((Para) l_stos.pop()).getWartosc(), 0.001);

	}
	
	

}
