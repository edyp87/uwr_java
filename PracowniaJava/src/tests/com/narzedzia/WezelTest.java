package tests.com.narzedzia;

import static org.junit.Assert.*;

import org.junit.Test;

import narzedzia.Para;
import narzedzia.Wezel;

public class WezelTest
{

	
	@Test
	public void wezelPrzechowujeSwojaPare() throws CloneNotSupportedException
	{
		Para  l_para  = new Para("klucz", 1);
		Wezel l_wezel = Wezel.wstaw(null, l_para);
		
		assertEquals(l_wezel.getPara().getWartosc(), l_para.getWartosc(), 0.001);
	}
	
	
	@Test
	public void wezelPotrafiWstawiacISzukacPary() throws CloneNotSupportedException
	{
		Para  l_para1  = new Para("klucz1", 1);
		Wezel l_wezel = Wezel.wstaw(null, l_para1);
		
		Para  l_para2  = new Para("klucz2", 2);
		Wezel.wstaw(l_wezel, l_para2);
		
		Para  l_para3  = new Para("klucz3", 3);
		Wezel.wstaw(l_wezel, l_para3);
		
		assertEquals(Wezel.szukaj(l_wezel, "klucz1").getPara().getWartosc(), l_para1.getWartosc(), 0.001);
		assertEquals(Wezel.szukaj(l_wezel, "klucz2").getPara().getWartosc(), l_para2.getWartosc(), 0.001);
		assertEquals(Wezel.szukaj(l_wezel, "klucz3").getPara().getWartosc(), l_para3.getWartosc(), 0.001);
	}
	
	
	@Test
	public void wezelPotrafiUsuwac() throws CloneNotSupportedException
	{
		Para  l_para1  = new Para("klucz1", 1);
		Wezel l_wezel = Wezel.wstaw(null, l_para1);
		
		Para  l_para2  = new Para("klucz2", 2);
		Wezel.wstaw(l_wezel, l_para2);
		
		Para  l_para3  = new Para("klucz3", 3);
		Wezel.wstaw(l_wezel, l_para3);
		
		assertEquals(Wezel.szukaj(l_wezel, "klucz1").getPara().getWartosc(), l_para1.getWartosc(), 0.001);
		assertEquals(Wezel.szukaj(l_wezel, "klucz2").getPara().getWartosc(), l_para2.getWartosc(), 0.001);
		assertEquals(Wezel.szukaj(l_wezel, "klucz3").getPara().getWartosc(), l_para3.getWartosc(), 0.001);
		
		Wezel.usun(l_wezel, "klucz2");
		
		assertEquals(Wezel.szukaj(l_wezel, "klucz1").getPara().getWartosc(), l_para1.getWartosc(), 0.001);
		assertEquals(Wezel.szukaj(l_wezel, "klucz2"), null);
		assertEquals(Wezel.szukaj(l_wezel, "klucz3").getPara().getWartosc(), l_para3.getWartosc(), 0.001);
		
		
		
		
	}
	
}
