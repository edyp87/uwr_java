package pracownia6.wyrazenieZPracowni3;

import java.math.BigInteger;

public class Stala extends Wyrazenie 
{
	public Stala(BigInteger l_wartosc)
	{
		m_wartosc = l_wartosc;
	}
	
	@Override
	public BigInteger oblicz()
	{
		return m_wartosc;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(m_wartosc);
	}
	
	private BigInteger m_wartosc;
}
