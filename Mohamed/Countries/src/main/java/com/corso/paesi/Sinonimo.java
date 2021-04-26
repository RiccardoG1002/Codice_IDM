package com.corso.paesi;

public class Sinonimo {
	private String cercata, algoritmo;
	private Paese paese;
	private int hits, approvato;
	
	
	public Paese getPaese() {
		return paese;
	}

	public void setPaese(Paese paese) {
		this.paese = paese;
	}

	public String getCercata() {
		return cercata;
	}

	public void setCercata(String cercata) {
		this.cercata = cercata;
	}


	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	public int getHits() {
		return hits;
	}

	private void setHits(int hits) {
		this.hits = hits;
	}
	
	public int getApprovato() {
		return approvato;
	}

	public void setApprovato(int approvato) {
		this.approvato = approvato;
	}

	public void increment() {
		setHits(getHits()+1);
	}

	@Override
	public String toString() {
		return "Sinonimo [cercata=" + cercata + ", algoritmo=" + algoritmo + ", paese=" + paese + ", hits=" + hits
				+ "]";
	}

	

	
}
