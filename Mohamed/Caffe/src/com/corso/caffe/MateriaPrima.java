package com.corso.caffe;

public enum MateriaPrima  {
	ZUCCHERO(1.00), CAFFE(8), LATTE(0.4), ACQUA(0.1);
	
	
	private double prezzo_unitario;
	
	
	MateriaPrima(double prezzo_unitario){
		this.prezzo_unitario = prezzo_unitario;
	}


	public double getPrezzoUnitario() {
		return prezzo_unitario;
	}
	public void setPrezzoUnitario(double prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}
		
}
