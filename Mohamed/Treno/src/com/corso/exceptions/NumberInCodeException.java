package com.corso.exceptions;

public class NumberInCodeException extends CodeFomratException{

	public NumberInCodeException() {
		super("La stringa del treno non puo contenere numeri");
		
	}

}
