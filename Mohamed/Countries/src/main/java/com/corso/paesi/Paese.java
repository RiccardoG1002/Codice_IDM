package com.corso.paesi;

public class Paese {

	private String codice;
	private String nome;
	

	public String getCodice() {
		return codice;
	}
	
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Paese [codice=" + codice + ", nome=" + nome + "]";
	}
	
	
}
