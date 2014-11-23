import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigInteger;

import pracownia6.dzialania.*;

public class WyrazenieTest {
        BigInteger l_wartosc = new BigInteger(String.valueOf(111));
	@Test
	public void StalaJestPoprawnieZwracana()
	{
            
		Stala l_stala = new Stala(l_wartosc);
		assertEquals(l_wartosc, l_stala.oblicz());
		assertTrue(l_stala.equals(new Stala(l_wartosc)));
	}
	
	@Test
	public void PoprawnieObliczanyJestPrzeciwnosc()
	{
		PrzeciwnyZnak l_minus = new PrzeciwnyZnak(new Stala(l_wartosc));
		assertEquals(l_wartosc.negate(), l_minus.oblicz());
		assertTrue(l_minus.equals(new Stala(l_wartosc.negate())));
	}
	
	@Test
	public void PoprawnieObliczanaJestSuma() throws RuntimeException
	{
		Dodaj l_dodaj = new Dodaj(new Stala(l_wartosc), new Stala(l_wartosc));
		assertEquals(l_wartosc.add(l_wartosc), l_dodaj.oblicz());
		assertTrue(l_dodaj.equals(new Stala(l_wartosc.add(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanaJestRoznica() throws RuntimeException
	{
		Odejmij l_odejmij = new Odejmij(new Stala(l_wartosc), new Stala(l_wartosc));
		assertEquals(l_wartosc.subtract(l_wartosc), l_odejmij.oblicz());
		assertTrue(l_odejmij.equals(new Stala(l_wartosc.subtract(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanyJestIloczyn() throws RuntimeException
	{
		Mnoz l_mnoz = new Mnoz(new Stala(l_wartosc), new Stala(l_wartosc));
		assertEquals(l_wartosc.multiply(l_wartosc), l_mnoz.oblicz());
		assertTrue(l_mnoz.equals(new Stala(l_wartosc.multiply(l_wartosc))));
	}
	
	@Test
	public void PoprawnieObliczanyJestIloraz() throws RuntimeException
	{
		Dziel l_dziel = new Dziel(new Stala(l_wartosc), new Stala(l_wartosc));
		assertEquals(l_wartosc.divide(l_wartosc), l_dziel.oblicz());
		assertTrue(l_dziel.equals(new Stala(l_wartosc.divide(l_wartosc))));
	}
	@Test
	public void PoprawnieObliczanaJestPotega() throws RuntimeException
	{
		Potega l_potega = new Potega(new Stala(l_wartosc), new Stala(l_wartosc));
                assertEquals(l_wartosc.pow(111), l_potega.oblicz());
                assertTrue(l_potega.equals(new Stala(l_wartosc.pow(111))));
	}
        
	@Test
	public void PoprawnieObliczanaJestSilnia() throws RuntimeException
        {
		Silnia l_silnia = new Silnia(new Stala(l_wartosc));
		assertEquals(obliczSilnie(l_wartosc), l_silnia.oblicz());
		assertTrue(l_silnia.equals(new Stala(obliczSilnie(l_wartosc))));
	}
        
        @Test
	public void PoprawnieObliczanyJestSymbolNewtona() throws RuntimeException
        {
		SymbolNewtona l_symbol = new SymbolNewtona(new Stala(BigInteger.valueOf(5)), new Stala(BigInteger.valueOf(2)));
		assertEquals(BigInteger.valueOf(10), l_symbol.oblicz());
//		assertTrue(l_silnia.equals(new Stala(obliczSilnie(l_wartosc))));
	}
        
        private BigInteger obliczSilnie(BigInteger l_n)
        {
            BigInteger l_result = BigInteger.ONE;
            
            while (!l_n.equals(BigInteger.ZERO))
            {
                l_result = l_result.multiply(l_n);
                l_n = (new Odejmij(new Stala(l_n), new Stala(BigInteger.ONE))).oblicz();
            }
            return l_result;
        }
        

}
