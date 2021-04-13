package com.corso.vagoni;

public abstract class Carrozza extends Vagone{

	private int numeroPosti;
	private static final double MEDIO_PESO_PERSONA = 100;

	public Carrozza(Dimensioni dimensioni, int maxPosti) {
		super(dimensioni);
		this.numeroPosti = maxPosti;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public
	double getmaxPeso() {
		return super.getmaxPeso() + numeroPosti * 100;
	}

	
	
	
}
