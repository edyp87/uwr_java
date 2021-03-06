package com.pracownia3;

public abstract class Wyrazenie
{
	public abstract double oblicz();
	public abstract String toString();
	@Override
	public boolean equals(Object p_wyrazenie)
	{
		if (p_wyrazenie == null)
			return false;
		if (p_wyrazenie == this)
			return true;
		if (!(p_wyrazenie instanceof Wyrazenie))
			return false;
		
		return this.oblicz() == ((Wyrazenie)p_wyrazenie).oblicz();
	}
}
