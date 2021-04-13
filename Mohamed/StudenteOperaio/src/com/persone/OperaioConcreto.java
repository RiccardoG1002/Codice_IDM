package com.persone;

public class OperaioConcreto extends Persona implements Operaio {
	
	private String mansione; 
		
	public OperaioConcreto(String nome, String cognome, String mansione) {
		super(nome, cognome);
		this.mansione = mansione;
	}

	@Override
	public String toString() {
		return "Operaio [nome=" + getNome() + ", cognome=" + getCognome() + ", mansione=" + mansione + "]";
	}

	@Override
	String stampaDatiPersonalizzati() {
		return "mansione: "+ mansione;
	}

	@Override
	public double getStipendio() {
		return ContrattoUtility.calcolaStipendioNetto(mansione);
	}

	@Override
	public String getMansione() {
		return mansione;
	}


	
}
