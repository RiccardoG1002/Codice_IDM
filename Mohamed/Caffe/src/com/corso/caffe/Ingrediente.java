package com.corso.caffe;

public class Ingrediente implements Comprabile{
	private double quantita;
	private MateriaPrima materia_prima;
	

	public Ingrediente( MateriaPrima materia_prima, double quantita) {
		super();
		this.quantita = quantita;
		this.materia_prima = materia_prima;
	}
	
	public double getQuantita() {
		return quantita;
	}
	public MateriaPrima getMateria_prima() {
		return materia_prima;
	}
	
	public double getPrezzo() {
		return materia_prima.getPrezzoUnitario() * quantita;
	}
	
	
	
	

}
