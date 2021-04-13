package Caffe;

import java.util.LinkedList;
import java.util.List;

import Ingredienti.Ingrediente;

public abstract class AbstractCaffe {

	private List<Ingrediente> ingerdienti = new LinkedList<Ingrediente>();
	
	public final void addIngrediente(Ingrediente ingrediente) {
		this.ingerdienti.add(ingrediente);
	}

	public final double prezzo(){
		double prezzo = 0;
		for (Ingrediente ingrediente : ingerdienti) {
			prezzo = prezzo + ingrediente.prezzo();
		}
		return prezzo;
	}
	
	public void descrizione() {
		System.out.println("Ingredienti: ");
		for (Ingrediente ingrediente : ingerdienti) {
			System.out.println(ingrediente);
		}
	}
	
}
