package Ingredienti;

public class Whiskey implements Ingrediente {

	@Override
	public double prezzo() {
		return 0.80;
	}
	
	@Override
	public String toString() {
		return "Whiskey";
	}

}
