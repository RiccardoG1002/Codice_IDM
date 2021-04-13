package Ingredienti;

public class PannaMontata implements Ingrediente {

	@Override
	public double prezzo() {
		return 0.20;
	}
	
	@Override
	public String toString() {
		return "Panna montata";
	}

}
