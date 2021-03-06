package narzedzia;

import narzedzia.Para;

public class Wezel implements Cloneable, Comparable<Para> 
{
	private Wezel(Para p_para, Wezel p_poprzedni, Wezel p_nastepny) throws CloneNotSupportedException
	{
		m_para      = (Para) p_para.clone();
		m_poprzedni = p_poprzedni;
		m_nastepny  = p_nastepny;
	}
	
	public static Wezel szukaj(Wezel p_korzen, String p_klucz) throws CloneNotSupportedException
	{
		if(p_korzen == null)
		{
			return null;
		}
		
		if(p_korzen.getPara().m_klucz.compareTo(p_klucz) < 0)
		{
			return szukaj(p_korzen.m_nastepny, p_klucz);
		}
		else if(p_korzen.getPara().m_klucz.compareTo(p_klucz) > 0)
		{
			return szukaj(p_korzen.m_poprzedni, p_klucz);
		}
		else
		{
			// rowne
			return p_korzen;
		}
	}
	
	public static Wezel wstaw(Wezel p_korzen, Para p_para) throws CloneNotSupportedException
	{
		if(p_korzen == null)
		{
			p_korzen = new Wezel(p_para, null, null);
		}
		else if(p_para.compareTo(p_korzen.getPara()) < 0)
		{
			p_korzen.m_poprzedni = wstaw(p_korzen.m_poprzedni, p_para);
		}
		else if(p_para.compareTo(p_korzen.getPara()) > 0)
		{
			p_korzen.m_nastepny = wstaw(p_korzen.m_nastepny, p_para);
		}
		else
		{
			// duplikat
		}
		return p_korzen;
		
	}
	
	public static void drukuj(Wezel p_wezel)
	{
		if(p_wezel != null)
		{
			drukuj(p_wezel.m_poprzedni);
			System.out.println(p_wezel.m_para);
			drukuj(p_wezel.m_nastepny);
		}
	}
	
	public static Wezel usun(Wezel p_wezel, String p_klucz)
	{
		if(p_wezel == null)
		{
			return null;
		}
		
		if(p_klucz.compareTo(p_wezel.getPara().m_klucz) < 0)
		{
			p_wezel.m_poprzedni = usun(p_wezel.m_poprzedni, p_klucz);
		}
		else if(p_klucz.compareTo(p_wezel.getPara().m_klucz) > 0)
		{
			p_wezel.m_nastepny = usun(p_wezel.m_nastepny, p_klucz);
		}
		else if (p_wezel.m_poprzedni != null && p_wezel.m_nastepny != null)
		{
			p_wezel.m_para = znajdzMin(p_wezel.m_nastepny).getPara();
			p_wezel.m_nastepny = usun(p_wezel.m_nastepny, p_wezel.m_para.m_klucz);
		}
		else 
		{
			p_wezel = (p_wezel.m_poprzedni != null) ? p_wezel.m_poprzedni : p_wezel.m_nastepny;
		}
		return p_wezel;
		
	}
	
	private static Wezel znajdzMin(Wezel p_wezel)
	{
		if(p_wezel == null)
		{
			return null;
		}
		else if(p_wezel.m_poprzedni == null)
		{
			return p_wezel;
		}
		return znajdzMin(p_wezel.m_poprzedni);
	}
	
	public Para getPara()
	{
		return m_para;
	}

	@Override
	public int compareTo(Para p_para)
	{
		return m_para.compareTo(p_para);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Wezel l_wezel = (Wezel) super.clone();
		l_wezel.m_para = (Para) m_para.clone();
		l_wezel.m_poprzedni = (Wezel) m_poprzedni.clone();
		l_wezel.m_nastepny = (Wezel) m_nastepny.clone();
		return l_wezel;
	}
	
	private Para  m_para;
	private Wezel m_poprzedni;
	private Wezel m_nastepny;
	
	

}
