package Ingredienti;

public class Acqua implements Ingrediente {

	@Override
	public double prezzo() {
		return 0.20;
	}
	
	@Override
	public String toString() {
		return "Acqua";
	}

}
