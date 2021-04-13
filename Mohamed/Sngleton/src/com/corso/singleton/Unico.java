package com.corso.singleton;


public class Unico {

	private static Unico istanza;
	
	static
	{istanza = new Unico();
		
	
	}
	
	
	private Unico() {
		super();
	}
	
	static Unico getIstanza() {
		return istanza;
	}
	

}
