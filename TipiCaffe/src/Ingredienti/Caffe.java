package Ingredienti;

public class Caffe implements Ingrediente {

	@Override
	public double prezzo() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Caffé";
	}

}
