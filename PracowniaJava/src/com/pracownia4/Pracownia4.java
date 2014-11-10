package com.pracownia4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

import narzedzia.DrzewoBST;
import narzedzia.Para;



public class Pracownia4
{
	public static void main(String [] p_dane) throws IOException, NumberFormatException, IllegalArgumentException, CloneNotSupportedException
	{
	    for (String l_idDrzewa : p_dane)
	    {
	    	System.out.println(l_idDrzewa);
	    	m_drzewa.put(l_idDrzewa, new DrzewoBST());
	    }
	    
	    BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	    
	    while (m_programDziala)
	    {
	    	String[] l_wejscie = cin.readLine().trim().split("\\s+");
	    	m_programDziala = obsluzWejscie(l_wejscie);
	    }
	    
	}

	private static boolean obsluzWejscie(String[] p_wejscie) throws NumberFormatException, IllegalArgumentException, CloneNotSupportedException
	{
		System.out.println(p_wejscie[0]);
		if(p_wejscie[0].equals("insert"))
		{
			DrzewoBST l_drzewo = m_drzewa.get(p_wejscie[1]);
			l_drzewo.wstaw(new Para(p_wejscie[2], Double.parseDouble(p_wejscie[3])));
			l_drzewo.
		}
		return true;
	}
	
	static Hashtable<String, DrzewoBST> m_drzewa = new Hashtable<String, DrzewoBST>();
	static boolean m_programDziala = true;
}
