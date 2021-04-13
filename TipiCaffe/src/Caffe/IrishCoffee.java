package Caffe;

import Ingredienti.*;


public class IrishCoffee extends AbstractCaffe {
	
	public IrishCoffee() {
		super.addIngrediente(new Caffe());
		super.addIngrediente(new Whiskey());
		super.addIngrediente(new PannaMontata());
	}

	@Override
	public void descrizione() {
		System.out.println("Irish Coffee");
		super.descrizione();
	}
	
}
