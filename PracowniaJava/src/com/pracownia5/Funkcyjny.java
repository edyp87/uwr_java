package com.pracownia5;

public interface Funkcyjny extends Obliczalny
{
	int arnosc();
	int brakujaceArgumenty();
	void dodajArgument(double p_arg); //throws WyjatekONP
}
