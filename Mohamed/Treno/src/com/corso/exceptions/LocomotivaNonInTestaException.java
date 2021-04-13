package com.corso.exceptions;

public class LocomotivaNonInTestaException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9043478850461786344L;

	public LocomotivaNonInTestaException() {
		super("La locomotiva deve essere in testa");
		
	}

}
