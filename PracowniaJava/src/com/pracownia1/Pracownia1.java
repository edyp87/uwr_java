package com.pracownia1;

public class Pracownia1 {
	public static void main(String [] p_liczby)
	{
		for(String l_liczba : p_liczby)
		{
			if (!sprawdzCzyPoprawna(l_liczba))
			{
				System.err.println("Podano blędną wartość!");
				continue;
			}
			LiczbySlownie liczbaSlownie = new LiczbySlownie(new Integer(l_liczba));
			System.out.println(liczbaSlownie.napiszLiczbe());
		}
		
	}
	
	private static Boolean sprawdzCzyPoprawna(String p_liczba)
	{
		try
		{
			Integer.parseInt(p_liczba);
		}
		catch(NumberFormatException l_exception)
		{
			return false;
		}
		return true;
	}

}
