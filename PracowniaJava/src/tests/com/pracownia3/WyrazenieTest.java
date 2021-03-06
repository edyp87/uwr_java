package tests.com.pracownia3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pracownia3.*;

public class WyrazenieTest {
	@Test
	public void StalaJestPoprawnieZwracana()
	{
		double l_wartosc = 1.2;
		Stala l_stala = new Stala(l_wartosc);
		assertEquals(l_wartosc, l_stala.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_stala.equals(new Stala(l_wartosc)));
	}
	
	@Test
	public void ZmiennaJestPoprawnieZwracana() throws RuntimeException
	{
		
		String  l_idZmiennej1 = "ID1";
		String  l_idZmiennej2 = "ID2";
		double l_wartosc1 = 0.0;
		double l_wartosc2 = 1.2;
		Zmienna l_zmienna1 = new Zmienna(l_idZmiennej1, l_wartosc1);
		Zmienna l_zmienna2 = new Zmienna(l_idZmiennej2, l_wartosc2);
		assertEquals(l_wartosc1, l_zmienna1.oblicz(), m_deltaDlaAsercji);
		assertEquals(l_wartosc2, l_zmienna2.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_zmienna1.equals(new Stala(l_wartosc1)));
		assertTrue(l_zmienna2.equals(new Stala(l_wartosc2)));
		
	}
	
	@Test
	public void PoprawnieObliczanyJestMinusStalej()
	{
		double l_wartosc = 1.2;
		PrzeciwnyZnak l_minus = new PrzeciwnyZnak(new Stala(l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_minus.equals(new Stala(-l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanyJestMinusZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDminus";
		PrzeciwnyZnak l_minus = new PrzeciwnyZnak(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_minus.equals(new Stala(-l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanaJestWartBezezglStalej()
	{
		double l_wartosc1 = -1.2;
		WartBezwzgl l_abs1 = new WartBezwzgl(new Stala(l_wartosc1));
		assertEquals(-l_wartosc1, l_abs1.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_abs1.equals(new Stala(-l_wartosc1)));
		
		double l_wartosc2 = 1.2;
		WartBezwzgl l_abs2 = new WartBezwzgl(new Stala(l_wartosc2));
		assertEquals(l_wartosc2, l_abs2.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_abs2.equals(new Stala(l_wartosc2)));
	}
	
	@Test
	public void PoprawnieObliczanyJestSinusZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDsinus";
		Sinus l_sinus = new Sinus(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.sin(l_wartosc), l_sinus.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_sinus.equals(new Stala(Math.sin(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanyJestCosinusZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDcosinus";
		Cosinus l_cosinus = new Cosinus(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.cos(l_wartosc), l_cosinus.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_cosinus.equals(new Stala(Math.cos(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanyJestArctanZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDarctan";
		Arctan l_arctan = new Arctan(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.atan(l_wartosc), l_arctan.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_arctan.equals(new Stala(Math.atan(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanaJestOdwrotnoscZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDodwrotnosc";
		Odwrotnosc l_odwr = new Odwrotnosc(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.pow(l_wartosc, -1), l_odwr.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_odwr.equals(new Stala(Math.pow(l_wartosc, -1))));
	}
	
	@Test
	public void PoprawnieObliczanaJestWartBezwzglDlaZmiennej() throws RuntimeException
	{
		double l_wartosc     = -1.2;
		String  l_idZmiennej  = "IDabs";
		WartBezwzgl l_minus = new WartBezwzgl(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(-l_wartosc, l_minus.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_minus.equals(new Stala(-l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanyJestLogarytmDlaZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "ID";
		Logarytm l_log = new Logarytm(new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.log(l_wartosc), l_log.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_log.equals(new Stala(Math.log(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanaJestSumaStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDsuma";
		Dodaj l_dodaj = new Dodaj(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc + l_wartosc, l_dodaj.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_dodaj.equals(new Stala(l_wartosc + l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanaJestRoznicaStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDroznica";
		Odejmij l_odejmij = new Odejmij(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc - l_wartosc, l_odejmij.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_odejmij.equals(new Stala(l_wartosc - l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanyJestIloczynStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDiloczyn";
		Mnoz l_mnoz = new Mnoz(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc * l_wartosc, l_mnoz.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_mnoz.equals(new Stala(l_wartosc * l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanyJestIlorazStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDiloraz";
		Dziel l_dziel = new Dziel(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(l_wartosc / l_wartosc, l_dziel.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_dziel.equals(new Stala(l_wartosc / l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanaJestFunWykladniczaStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDfunwykl";
		FunWykladnicza l_funwykl = new FunWykladnicza(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.pow(l_wartosc, l_wartosc), l_funwykl.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_funwykl.equals(new Stala(Math.pow(l_wartosc, l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanaJestFunPotegaStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc     = 1.2;
		String  l_idZmiennej  = "IDpotega";
		Potega l_potega = new Potega(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc));
		assertEquals(Math.pow(l_wartosc, l_wartosc), l_potega.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_potega.equals(new Stala(Math.pow(l_wartosc, l_wartosc))));
	}
	
	@Test
	public void PoprawnieWybieraneJestMinimumZeStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc      = 1.2;
		String  l_idZmiennej  = "IDmin";
		Minimum l_min = new Minimum(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc+1));
		assertEquals(l_wartosc, l_min.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_min.equals(new Stala(l_wartosc)));
	}
	
	@Test
	public void PoprawnieWybieraneJestMaximumZeStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc      = 1.2;
		String  l_idZmiennej  = "IDmax";
		Maximum l_max = new Maximum(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc+1));
		assertEquals(l_wartosc+1, l_max.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_max.equals(new Stala(l_wartosc+1)));
	}
	
	@Test
	public void PoprawnieUstalanaJestRelacjaMniejszosciZeStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc      = 1.2;
		String  l_idZmiennej  = "IDmniejsze";
		Mniejsze l_mniejsze = new Mniejsze(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc+1));
		assertEquals(1.0, l_mniejsze.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_mniejsze.equals(new Stala(1.0)));
	}
	
	@Test
	public void PoprawnieUstalanaJestRelacjaWiekszosciZeStalejIZmiennej() throws RuntimeException
	{
		double l_wartosc      = 1.2;
		String  l_idZmiennej  = "IDwieksze";
		Wieksze l_wieksze = new Wieksze(new Stala(l_wartosc), new Zmienna(l_idZmiennej, l_wartosc+1));
		assertEquals(0.0, l_wieksze.oblicz(), m_deltaDlaAsercji);
		assertTrue(l_wieksze.equals(new Stala(0.0)));
	}
	
	@Test
	public void PoprawnieWylizaneSaPrzykladyZListyZadan() throws RuntimeException
	{
		Wyrazenie[] l_przyklady = wygenerujPrzyklady();
		
		assertEquals( 8.0,    l_przyklady[0].oblicz(), m_deltaDlaAsercji);
		assertEquals(-9.3260, l_przyklady[1].oblicz(), m_deltaDlaAsercji);
		assertEquals( 2.6666, l_przyklady[2].oblicz(), m_deltaDlaAsercji);
		assertEquals(-9.2080, l_przyklady[3].oblicz(), m_deltaDlaAsercji);
		assertEquals(1.0,     l_przyklady[4].oblicz(), m_deltaDlaAsercji);
		
		assertEquals("(3.0+5.0)", l_przyklady[0].toString());
		assertEquals("(2.0+([Klucz: x; Wartosc: -1.618]*7.0))", l_przyklady[1].toString());
		assertEquals("(((3.0*11.0)-1.0)/(7.0+5.0))",    l_przyklady[2].toString());
		assertEquals("((([Klucz: x; Wartosc: -1.618]+13.0)*[Klucz: x; Wartosc: -1.618])/2.0)", l_przyklady[3].toString());
		assertEquals("(((17.0*[Klucz: x; Wartosc: -1.618])+19.0)<0.0)", l_przyklady[4].toString());	
	}
	
	private Wyrazenie[] wygenerujPrzyklady() throws RuntimeException
	{

		Wyrazenie[] l_przyklady = new Wyrazenie[5];
			
		new Zmienna("x", -1.618);
			   
			l_przyklady[0] = new Dodaj(
					   				new Stala(3.0), 
					   				new Stala(5.0));
			l_przyklady[1] = new Dodaj(
					   				new Stala(2.0), 
					   				new Mnoz(
					   					new Zmienna("x"), 
					   					new Stala(7.0)));
			l_przyklady[2] = new Dziel(
								    new Odejmij(
									    new Mnoz(
										    new Stala(3.0),
										    new Stala(11.0)), 
									    new Stala(1)),
									new Dodaj(
									    new Stala(7.0),
									    new Stala(5.0)));
			l_przyklady[3] = new Dziel(
					   				new Mnoz(
					   					new Dodaj(
					   						new Zmienna("x"),
					   						new Stala(13.0)),
					   					new Zmienna("x")),
					   				new Stala(2));
			l_przyklady[4] = new Mniejsze(
					   				new Dodaj(
					   					new Mnoz(
					   						new Stala(17.0),
					   						new Zmienna("x")),
					   					new Stala(19.0)),
					   				new Stala(0.0));
		return l_przyklady;
	}
	
	private final double m_deltaDlaAsercji = 0.001;

}
