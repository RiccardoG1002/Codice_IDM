package com.corso.exceptions;

public class NotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -999217534814773709L;

	public NotFoundException(String type, String nome) {
		super("Il "+ type.toLowerCase() + " " + nome + " non esiste");
	}

}
