package com.pracownia3;

public class PrzeciwnyZnak extends Operator1Arg
{
	public PrzeciwnyZnak(Wyrazenie p_argument)
	{
		super(p_argument);
	}

	@Override
	public double oblicz() {
		return -1 * m_argumentPrawy.oblicz();
	}
}