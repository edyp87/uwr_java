package tests.pracownia5;

import static org.junit.Assert.*;

import com.pracownia3.Para;

import org.junit.Test;

import com.pracownia5.Lista;

public class ListaTest {

	@Test
	public void Test()
	{
		Lista l_lista = new Lista();
		l_lista.wstaw(new Para("ID1", 0));
		l_lista.wstaw(new Para("ID2", 1));
		l_lista.wstaw(new Para("ID3", 2));
		l_lista.wstaw(new Para("ID4", 2));
		l_lista.wstaw(new Para("ID5", 2));
		l_lista.wstaw(new Para("ID6", 3));
		
		l_lista.usun(2);
		l_lista.usun(3);
		
		for(int i = 0; l_lista.wartoscNaPozycji(i) != null; ++i )
		{
			assertEquals(i, ((Para)l_lista.wartoscNaPozycji(i)).getWartosc(), 0.001);
		}
	}

}
