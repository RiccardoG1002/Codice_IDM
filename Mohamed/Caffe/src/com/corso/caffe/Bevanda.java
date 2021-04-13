package com.corso.caffe;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Bevanda implements Comprabile {
	private Collection<Ingrediente> ingredienti;
	private String nome;
	private static double NETTO_ZUCCHERO_IN_BUSTINA = 5;
	
	public Bevanda(Bevande bevanda){
		ingredienti = new LinkedList<Ingrediente>();
		Collections.addAll(ingredienti, bevanda.getIngredienti());
		this.nome = bevanda.toString();
	}
	
	public double getPrezzo() {
		double prezzo = 0.00;
		for (Ingrediente i: ingredienti) {
			prezzo += i.getPrezzo();
		}
		return prezzo;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void aggiungiZucchero(int bustine) {
		ingredienti.add(new Ingrediente(MateriaPrima.ZUCCHERO, bustine * NETTO_ZUCCHERO_IN_BUSTINA));
	}
	

	
}
