package com.pracownia1;

public class LiczbySlownie 
{
	public LiczbySlownie(long p_liczba)
	{
		liczba = p_liczba;
	}

	public String napiszLiczbe() 
	{
		return zwiekszPierwszaLitere(dodajMinusJezeliUjemna() + zamienWartoscBezwzglednaNaSlowo());
	}
	
	public String napiszLiczbe(long p_liczba)
	{
		liczba = p_liczba;
		return zwiekszPierwszaLitere(dodajMinusJezeliUjemna() + zamienWartoscBezwzglednaNaSlowo());
	}
	
	
	
	
	
	
	private String zamienWartoscBezwzglednaNaSlowo()
	{
		if(liczba == 0)
		{
			return "zero";
		}
		
		long l_liczba = wartoscBezwzgledna(liczba);
		
		String l_liczbaSlownie = "";
		
		long l_poziom = 0;
		
		while(l_liczba > 0)
		{
			Stan stan = new Stan(l_liczba);
			
		    l_liczbaSlownie = stan.dodajPoziom(l_poziom) + l_liczbaSlownie;

		    l_poziom++;
			
			l_liczba /= 1000;
		}
		
		return l_liczbaSlownie.substring(1);
	}

	private String zwiekszPierwszaLitere(String p_liczbaSlownie)
	{
		return p_liczbaSlownie.substring(0, 1).toUpperCase() + p_liczbaSlownie.substring(1);
	}
	
	private String dodajMinusJezeliUjemna()
	{
		if (liczba < 0)
		{
			return "minus ";
		}
		return "";
	}
	
	private long wartoscBezwzgledna(long p_liczba) 
	{
		if (liczba < 0)
		{
			return -liczba;
		}
		return liczba;
	}
	
	
	
	
	
	
	
	
	
	
	
	private class Stan
	{
		public Stan(long p_liczba)
		{
			inicjalizuj(p_liczba);
			
			if (saNastki())
			{
				zrobNastkiOrazZignorujDziesiatkiIJednosci();
			}
		}
		
		private void inicjalizuj(long p_liczba)
		{
			setki      = wezSetki(p_liczba);
			dziesiatki = wezDziesiatki(p_liczba);
			jednosci   = wezJednosci(p_liczba);
			nastki     = 0;
		}
		
		private String dodajPoziom(long p_poziom)
		{
			if (jestCosDoDopisaniaNaTymPoziomie())
			{
				return dodajSetki(setki) 
				     + dodajDziesiatki(dziesiatki) 
					 + dodajNastki(nastki) 
					 + dodajJednosci(jednosci)          
					 + dodajKoncowki(p_poziom);
			}
			return "";
		}
		
		private void zrobNastkiOrazZignorujDziesiatkiIJednosci()
		{
			nastki     = jednosci;
			dziesiatki = jednosci = 0;		
		}
		
		private Boolean saNastki()
		{
			return dziesiatki == 1 && jednosci > 0;
		}
		
		private String dodajKoncowki(long p_poziom)
		{
			long koncowki = 2;
			if (jednosci == 1 && setki + dziesiatki + nastki == 0)
			{
				koncowki = 0;
			}
			if (jednosci == 2 || jednosci == 3 || jednosci == 4)
			{
				koncowki = 1;
			}
			return grupyTab[(int)p_poziom][(int)koncowki];
		}
		
		private String dodajSetki(long p_setki)
		{
			return setkiTab[(int)p_setki];
		}
		
		private String dodajDziesiatki(long p_dziesiatki)
		{
			return dziesiatkiTab[(int)p_dziesiatki];
		}
		
		private String dodajNastki(long p_nastki)
		{
			return kilkaNastkiTab[(int)p_nastki];
		}
		
		private String dodajJednosci(long p_jednosci)
		{
			return jednosciTab[(int)p_jednosci];
		}
		
		private Boolean jestCosDoDopisaniaNaTymPoziomie()
		{
			return setki + dziesiatki + nastki + jednosci > 0;
		}
		
		private long wezSetki(long p_liczba)
		{
			return wezPozycje(p_liczba, 100);
		}
		
		private long wezDziesiatki(long p_liczba)
		{
			return wezPozycje(p_liczba, 10);
		}
		
		private long wezJednosci(long p_liczba)
		{
			return wezPozycje(p_liczba, 1);
		}
		
		private long wezPozycje(long p_liczba, long p_pozycja)
		{
			return (long) (p_liczba % (p_pozycja*10) / p_pozycja);
		}
		
		private long setki;
		private long dziesiatki;
		private long jednosci;
		private long nastki;
	}
	
	
	
	
	
	
	
	
	private long liczba;
	
	private static final String jednosciTab[] = 
		{
			"", " jeden", " dwa", " trzy", " cztery", " pięć", " sześć", " siedem", " osiem", " dziewięć"
		};
		
		private static final String dziesiatkiTab[] = 
		{
			"", " dziesięć",     " dwadzieścia",   " trzydzieści",    " czterdzieści",
			    " pięćdziesiąt", " sześćdziesiąt", " siedemdziesiąt", " osiemdziesiąt", " dziewięćdziesiąt"
		};
		
		private static final String kilkaNastkiTab[] =
		{
			 "", " jedenaście", " dwanaście",  " trzynaście",   " czternaście", 
			     " piętnaście", " szesnaście", " siedemnaście", " osiemnaście", " dziewiętnaście", 
		};
		
		private static final String setkiTab[] =
		{
			 "", " sto",     " dwieście", " trzysta",   " czterysta", 
			     " pięćset", " sześćset", " siedemset", " osiemset", " dziewięćset", 
		};
		private static final String grupyTab[][] = {
			{"" ,"" ,""},
			{" tysiąc" ," tysiące" ," tysięcy"},
			{" milion" ," miliony" ," milionów"},
			{" miliard"," miliardy"," miliardów"}
		};	
}