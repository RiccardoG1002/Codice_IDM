package Ingredienti;

public class Latte implements Ingrediente {

	@Override
	public double prezzo() {
		return 0.50;
	}
	
	@Override
	public String toString() {
		return "Latte";
	}

}