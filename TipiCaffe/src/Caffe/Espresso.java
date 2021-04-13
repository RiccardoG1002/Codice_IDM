package Caffe;

import Ingredienti.*;

public class Espresso extends AbstractCaffe {
	
	public Espresso() {
		super.addIngrediente(new Caffe());
	}
	
	@Override
	public void descrizione() {
		System.out.println("Espresso");
		super.descrizione();
	}
}