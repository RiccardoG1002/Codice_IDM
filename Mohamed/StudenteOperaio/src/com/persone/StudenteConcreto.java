package com.persone;

public class StudenteConcreto extends Persona implements Studente{
	
	private String matricola; 
	
	public StudenteConcreto(String nome, String cognome, String matricola) {
		super(nome, cognome); 
		this.matricola = matricola;
	}

           
	public String toString() {
		return "Studente [nome=" + getNome() + ", cognome=" + getCognome() + ", matricola=" + matricola + "]";
	}

	@Override
	String stampaDatiPersonalizzati() {
		
		return "matricola: "+ matricola;
	}


	public String getMatricola() {
		return matricola;
	}


	@Override
	public double calcolaTasseUniversitarie() {
		return IscrizioneUtility.calcolaTasseUniversitarie(matricola);
	}
	
	
}

