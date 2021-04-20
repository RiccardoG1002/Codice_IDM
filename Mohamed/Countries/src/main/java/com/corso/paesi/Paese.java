package com.corso.paesi;

import java.util.Collection;

public class Paese {

	private String codice;
	private String nome;
	private Collection<Sinonimo> sinonimi; 
	

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

	public Collection<Sinonimo> getSinonimi(){
		return sinonimi;
	}

	public void setSinonimi(Collection<Sinonimo> sinonimi) {
		this.sinonimi = sinonimi;
	}
	
	
	
	
}
