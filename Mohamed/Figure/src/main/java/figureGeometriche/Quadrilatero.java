package figureGeometriche;

import java.util.Arrays;

public abstract class Quadrilatero implements Figura{
	
	private static int dim = 4;
	private Double[] lati;
	private Double[] angoli;
	
	public Quadrilatero(Double[] lati, Double[] angoli){
		this.lati = lati;
		this.angoli = angoli;
	}
	
	

	@Override
	public double getPerimetro() {
		return Arrays.stream(lati).mapToDouble(i -> i.doubleValue()).sum();
	}




	

}
