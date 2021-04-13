package Caffe;

import Ingredienti.Caffe;
import Ingredienti.Latte;


public class Cappuccino extends AbstractCaffe {

	public Cappuccino() {
		super.addIngrediente(new Caffe());
		super.addIngrediente(new Latte());
	}
	
	@Override
	public void descrizione() {
		System.out.println("Cappuccino");
		super.descrizione();
	}
}
