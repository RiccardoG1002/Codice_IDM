package com.corso.bar;

import com.corso.caffe.Bevanda;
import com.corso.caffe.Bevande;
import com.corso.caffe.MateriaPrima;

public class Bar {

	public static void main(String[] args) {
		
		Bevanda espresso = new Bevanda(Bevande.ESPRESSO);
		Bevanda latte_macchiato = new Bevanda(Bevande.LATTE_MACCHIATO);
	    Bevanda cappuccino = new Bevanda(Bevande.CAPPUCINO);
	    
	    Bevanda[] bevande = new Bevanda[] {espresso, latte_macchiato, cappuccino};
	    
	    for(Bevanda b: bevande) {
	    	System.out.println("Il costo della bevanda: "+  b.toString() + " " + "è di:" + " " + String.format("%.2f", b.getPrezzo()));
	    }
	    
	    
	    for(Bevanda b: bevande) {
	    	System.out.println("Il costo della bevanda: "+  b.toString() + " " + "è di:" + " " + String.format("%.2f", b.getPrezzo()));
	    }
		
		
		
		
	}
	
}
