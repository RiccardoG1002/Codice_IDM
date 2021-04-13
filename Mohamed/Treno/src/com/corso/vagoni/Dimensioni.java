package com.corso.vagoni;

public enum Dimensioni {
	DIMENSIONI_A(100,100,100,3000), DIMENSIONI_B(100,100,100,2500), DIMENSIONI_CARGO(200,100,100,300);
	
	private double lunghezza, larghezza, altezza,  peso;
	
	private Dimensioni(double lunghezza, double larghezza, double altezza, double maxPeso) {
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.peso = maxPeso;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public double getMaxPeso() {
		return peso;
	}

	public void setMaxPeso(double maxPeso) {
		this.peso = maxPeso;
	}

	

}
