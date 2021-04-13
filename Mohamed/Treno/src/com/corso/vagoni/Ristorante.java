package com.corso.vagoni;

public abstract class Ristorante extends Vagone {

	public Ristorante(Dimensioni dimensioni) {
		super(dimensioni);
	}



	@Override
	public String toString() {
		return "R";
	}

}
