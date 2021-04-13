package com.corso.exceptions;

public class PesoEccessoException extends RuntimeException{

	public PesoEccessoException(double peso, double maxTrainabile) {
		super("Il peso massimo trainabile è di: "+maxTrainabile + ".");
	}

}
