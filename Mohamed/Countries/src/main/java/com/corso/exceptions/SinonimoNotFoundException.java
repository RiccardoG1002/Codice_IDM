package com.corso.exceptions;

import com.corso.paesi.Sinonimo;

public class SinonimoNotFoundException extends NotFoundException {

	public SinonimoNotFoundException(String sinonimo) {
		super(Sinonimo.class.getSimpleName(), sinonimo);
		// TODO Auto-generated constructor stub
	}

}
