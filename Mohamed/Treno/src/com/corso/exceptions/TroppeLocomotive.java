package com.corso.exceptions;

public class TroppeLocomotive extends RuntimeException {

	public TroppeLocomotive() {
		super("Un treno non puo contenere piu di una locomotiva");
	
	}

}
