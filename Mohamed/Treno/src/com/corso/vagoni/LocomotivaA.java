package com.corso.vagoni;

public class LocomotivaA extends Locomotiva {

	private static final double MAX_PESO_TRAINABILE = 90000;
	

	public LocomotivaA() {
		super(Dimensioni.DIMENSIONI_A);
	}

	@Override
	public double getMaxPesoTrainabile() {
		return MAX_PESO_TRAINABILE;
	}

}
