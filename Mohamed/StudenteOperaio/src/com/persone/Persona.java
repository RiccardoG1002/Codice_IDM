package com.persone;

public abstract class Persona {
	private String nome;
	private String cognome; 
	
	Persona(String nome, String cognome){
		this.cognome = cognome;
		this.nome = nome;
	}
	
	String getNome() {
		return this.nome;
	}
	
	String getCognome() {
		return this.cognome;
	}
	
	// final non puo essere sovrascritta! 
	public final void stampaDati() {
		System.out.println("dati anagrafici: " +getNome() + 
				" " + getCognome() + " " + stampaDatiPersonalizzati());
	}

	abstract String stampaDatiPersonalizzati() ;
	
	

}
