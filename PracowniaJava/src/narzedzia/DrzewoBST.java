package narzedzia;

public class DrzewoBST implements Slownik, Comparable<DrzewoBST>, Cloneable
{
	
	@Override
	public int compareTo(DrzewoBST o)
	{
		return 0;
	}

	@Override
	public double szukaj(String p_klucz) throws CloneNotSupportedException
	{
		return Wezel.szukaj(m_korzen, p_klucz).getPara().getWartosc();
	}

	@Override
	public boolean wstaw(Para p_para) throws CloneNotSupportedException
	{
		Wezel.wstaw(m_korzen, p_para);
		m_rozmiar++;
		return true;
	}

	@Override
	public boolean usun(String p_klucz)
	{
		if (Wezel.usun(m_korzen, p_klucz) != null)
		{
			m_rozmiar--;
			return true;
		}
		return false;
	}

	@Override
	public int ile()
	{
		return m_rozmiar;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		DrzewoBST l_drzewo = (DrzewoBST) super.clone();
		l_drzewo.m_korzen = (Wezel) m_korzen.clone();
		return l_drzewo;
	}
	
	int m_rozmiar = 0;
	Wezel m_korzen;
}