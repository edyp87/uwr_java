package com.pracownia1;

import static org.junit.Assert.*;

import org.junit.Test;


public class LiczbySlownieTest {
	@Test
	public void zwracaZero()
	{
		LiczbySlownie liczba = new LiczbySlownie(0);
		assertEquals("Zero", liczba.napiszLiczbe());
		
	}
	
	@Test
	public void zwracaJeden()
	{
		LiczbySlownie liczba = new LiczbySlownie(1);
		assertEquals("Jeden", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaDwa()
	{
		LiczbySlownie liczba = new LiczbySlownie(2);
		assertEquals("Dwa", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaUjemna()
	{
		LiczbySlownie liczba = new LiczbySlownie(-2);
		assertEquals("Minus dwa", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaDziesiec()
	{
		LiczbySlownie liczba = new LiczbySlownie(10);
		assertEquals("Dziesięć", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaDwadziescia()
	{
		LiczbySlownie liczba = new LiczbySlownie(20);
		assertEquals("Dwadzieścia", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaTrzydziesci()
	{
		LiczbySlownie liczba = new LiczbySlownie(30);
		assertEquals("Trzydzieści", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaJedenascie()
	{
		LiczbySlownie liczba = new LiczbySlownie(11);
		assertEquals("Jedenaście", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaSiedemnaście()
	{
		LiczbySlownie liczba = new LiczbySlownie(17);
		assertEquals("Siedemnaście", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaDwadziesciaOsiem()
	{
		LiczbySlownie liczba = new LiczbySlownie(28);
		assertEquals("Dwadzieścia osiem", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaCzterdziesciDwa()
	{
		LiczbySlownie liczba = new LiczbySlownie(42);
		assertEquals("Czterdzieści dwa", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaSto()
	{
		LiczbySlownie liczba = new LiczbySlownie(100);
		assertEquals("Sto", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaCzterysta()
	{
		LiczbySlownie liczba = new LiczbySlownie(400);
		assertEquals("Czterysta", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaOsiemsetCzterdziesciDwa()
	{
		LiczbySlownie liczba = new LiczbySlownie(842);
		assertEquals("Osiemset czterdzieści dwa", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaTrzystaDwanascie()
	{
		LiczbySlownie liczba = new LiczbySlownie(312);
		assertEquals("Trzysta dwanaście", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaDwanascieMilionowCzterystaPiecdziesiatDziewiecTysiecyCzterystaTrzynascie()
	{
		LiczbySlownie liczba = new LiczbySlownie(12459413);
		assertEquals("Dwanaście milionów czterysta pięćdziesiąt dziewięć tysięcy czterysta trzynaście", liczba.napiszLiczbe());
	}
	
	@Test
	public void zwracaBardzoMalaLiczbe()
	{
		LiczbySlownie liczba = new LiczbySlownie(-2147483648);
		assertEquals("Minus dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści osiem", liczba.napiszLiczbe());
	}
}
