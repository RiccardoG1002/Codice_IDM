package com.corso.exceptions;

import com.corso.paesi.Paese;

public class PaeseNotFoundException extends NotFoundException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5244263331824982859L;
	
	public PaeseNotFoundException(String inputPaese) {
		super(Paese.class.getSimpleName(), inputPaese);
	}

}
