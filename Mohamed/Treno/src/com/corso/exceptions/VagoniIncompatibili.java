package com.corso.exceptions;

public class VagoniIncompatibili extends RuntimeException {

	public VagoniIncompatibili(String string) {
		super("I vagoni non sono compatibili. "+ string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2516553293645376152L;

}
