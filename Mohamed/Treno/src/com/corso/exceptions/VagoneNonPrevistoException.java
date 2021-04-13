package com.corso.exceptions;

public class VagoneNonPrevistoException extends CodeFomratException {

	public VagoneNonPrevistoException(char vagone) {
		super("Il vagone "+ vagone + " non è previsto");
		
	}

}
