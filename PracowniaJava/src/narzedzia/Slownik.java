package narzedzia;

public interface Slownik
{
	public double szukaj(String p_klucz) throws CloneNotSupportedException;
	public boolean wstaw(Para p_para) throws CloneNotSupportedException;
	public boolean usun(String p_klucz);
	public int ile();
}
