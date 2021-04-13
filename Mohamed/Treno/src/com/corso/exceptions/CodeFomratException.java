package com.corso.exceptions;

public class CodeFomratException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeFomratException(String errore) {
		super("Errore stringa treno: "+ errore);
	}
}
