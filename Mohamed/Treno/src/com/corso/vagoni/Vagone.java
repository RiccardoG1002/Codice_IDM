package com.corso.vagoni;

public abstract class Vagone {
	
	private Dimensioni dimensioni;

	public Vagone(Dimensioni dimensioni) {
		super();
		this.dimensioni = dimensioni;
	}
	
	public double getmaxPeso(){
		return dimensioni.getMaxPeso();
	}
	
	

}
