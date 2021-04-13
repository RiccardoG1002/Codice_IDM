package com.corso.exceptions;

public class TroppiRistorantiException extends RuntimeException {

	public TroppiRistorantiException() {
		super("Un treno puo contenere al massimo due ristoranti");
	
	}

}
