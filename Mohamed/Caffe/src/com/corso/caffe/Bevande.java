package com.corso.caffe;

public enum Bevande {
	ESPRESSO(new Ingrediente[]{new Ingrediente(MateriaPrima.CAFFE,7e-3), new Ingrediente(MateriaPrima.ACQUA,70e-3)}), 
	CAPPUCINO(new Ingrediente[]{new Ingrediente(MateriaPrima.CAFFE,7e-3), new Ingrediente(MateriaPrima.ACQUA,70e-3), new Ingrediente(MateriaPrima.LATTE,70e-3)}), 
	LATTE_MACCHIATO(new Ingrediente[]{new Ingrediente(MateriaPrima.CAFFE,7e-3), new Ingrediente(MateriaPrima.ACQUA,70e-3), new Ingrediente(MateriaPrima.LATTE,100e-3)});
	
	private Ingrediente[] ingredienti;
	
	Bevande(Ingrediente[] ingredienti){
		this.ingredienti = ingredienti;
	}
	
	public Ingrediente[] getIngredienti() {
		return ingredienti;
	}
	
	
}
