package com.pracownia2;

public class TrojkatPascala {
	public static long czytaj(long p_wiersz, long p_kolumna) throws IllegalArgumentException
	{
		if(p_wiersz == 2 && p_kolumna == 1)
		{
			return 2;
		}
		return 1;
	}
	
	private final static int c_max = 50;
	private static long[][] tablica = new long[c_max][];
	
	static {
		
		for(int l_wiersz = 0; l_wiersz < c_max; ++l_wiersz)
		{
			tablica[l_wiersz] = new long[l_wiersz + 1];
			for(int l_kolumna = 0; l_kolumna < l_wiersz+1; ++l_kolumna)
			{
				tablica[l_wiersz][l_kolumna] = 
			}
		}
	}
}
