package com.corso.vagoni;

public abstract class Locomotiva extends Vagone {
	
	public Locomotiva(Dimensioni dimensioni) {
		super(dimensioni);
	}

	public abstract double getMaxPesoTrainabile();
	
	@Override
	public String toString() {
		return "H";
	}

}
