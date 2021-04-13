package com.corso.vagoni;

public class LocomotivaB extends Locomotiva{
	
	private static final double MAX_PESO_TRAINABILE = 80000;
	

	public LocomotivaB() {
		super(Dimensioni.DIMENSIONI_A);
	}

	@Override
	public double getMaxPesoTrainabile() {
		return MAX_PESO_TRAINABILE;
	}
}
