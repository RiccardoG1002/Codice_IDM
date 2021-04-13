package com.corso.vagoni;

public class Cargo extends Vagone{

	private int maxContainer;
	
	public Cargo(int maxContainer) {
		super(Dimensioni.DIMENSIONI_CARGO);
		this.maxContainer = maxContainer;
	}

	public int getMaxContainer() {
		return maxContainer;
	}

	@Override
	public String toString() {
		return "C";
	}

}
