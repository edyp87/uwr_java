package com.pracownia5;

import java.util.HashSet;

import com.pracownia3.Para;

public class Zmienna extends Operand
{
	public Zmienna(String p_id, double p_wartosc)
	{
		m_para = new Para(p_id, p_wartosc);
		addToSet();
	}
	
	public String getId()
	{
		return m_para.m_klucz;
	}
	
	public double getWartosc()
	{
		return m_para.getWartosc();
	}
	
	private void addToSet()
	{
		if (m_zbior.contains(m_para))
		{
			m_zbior.remove(m_para);
			
		}
		m_zbior.add(m_para);
	}
	
	@Override
	public boolean equals(Object p_zmienna)
	{
		if (p_zmienna == null)               return false;
		if (p_zmienna == this)               return true;
		if (!(p_zmienna instanceof Zmienna)) return false;
		
		return this.getId() == ((Zmienna)p_zmienna).getId();
	}
	
	@Override
	public double obliczWartosc()
	{
		return getWartosc();
	}
	
	private Para m_para;
	private static HashSet<Para> m_zbior = new HashSet<Para>();
}
