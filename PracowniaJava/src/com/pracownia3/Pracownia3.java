package com.pracownia3;

public class Pracownia3 {

	public static void main(String [] p_dane)
	{
		obliczPrzyklady();
	}
	
	private static void wygenerujPrzyklady() throws Exception
	{
		m_przyklady = new Wyrazenie[5];
		
		new Zmienna("x", -1.618);
		   
		   m_przyklady[0] = new Dodaj(
				   				new Stala(3.0), 
				   				new Stala(5.0));
		   m_przyklady[1] = new Dodaj(
				   				new Stala(2.0), 
				   				new Mnoz(
				   					new Zmienna("x"), 
				   					new Stala(7.0)));
		   m_przyklady[2] = new Dziel(
							    new Odejmij(
								    new Mnoz(
									    new Stala(3.0),
									    new Stala(11.0)), 
								    new Stala(1)),
								new Dodaj(
								    new Stala(7.0),
								    new Stala(5.0)));
		   m_przyklady[3] = new Dziel(
				   				new Mnoz(
				   					new Dodaj(
				   						new Zmienna("x"),
				   						new Stala(13.0)),
				   					new Zmienna("x")),
				   				new Stala(2));
		   m_przyklady[4] = new Mniejsze(
				   				new Dodaj(
				   					new Mnoz(
				   						new Stala(17.0),
				   						new Zmienna("x")),
				   					new Stala(19.0)),
				   				new Stala(0.0));
	}
	
	private static void obliczPrzyklady()
	{
		for (Wyrazenie l_wyrazenie : m_przyklady)
		{
			System.out.print(l_wyrazenie.toString() + " = ");
			System.out.println(l_wyrazenie.oblicz());
		}
	}
	
	static 
	{
		try
		{
			wygenerujPrzyklady();
		} 
		catch (Exception e) {}
	}
	
	private static Wyrazenie[] m_przyklady;

}