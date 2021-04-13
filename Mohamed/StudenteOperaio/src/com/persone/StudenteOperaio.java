package com.persone;

public class StudenteOperaio extends Persona implements Studente, Operaio{

	private String matricola, mansione;
	
	public StudenteOperaio(String nome, String cognome, String matricola,
			String mansione) {
		super(nome, cognome);
		this.matricola = matricola;
		this.mansione = mansione;
	}


	@Override
	String stampaDatiPersonalizzati() {
		// TODO Auto-generated method stub
		return "matricola: " + matricola + " "+ "mansione: " + mansione ;
	}


	@Override
	public String getMatricola() {
		return matricola;
	}


	@Override
	public double getStipendio() {
		return ContrattoUtility.calcolaStipendioNetto(mansione);
	}


	@Override
	public String getMansione() {
		return mansione;
	}


	@Override
	public double calcolaTasseUniversitarie() {
		return IscrizioneUtility.calcolaTasseUniversitarie(matricola);
	}

}
