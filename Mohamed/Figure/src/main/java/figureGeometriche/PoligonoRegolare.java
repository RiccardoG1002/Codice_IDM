package figureGeometriche;

public class PoligonoRegolare implements Figura{

	private double apotema;
	private double lato;
	private int numero_lati;
	
	
	PoligonoRegolare(double apotema, double lato, int numero_lati){
		this.apotema = apotema;
		this.lato = lato;
		this.numero_lati = numero_lati;
		
	}
	
	@Override
	public double getArea() {
		
		return getPerimetro() * apotema / 2;
	}

	@Override
	public double getPerimetro() {
		return lato * numero_lati;
	}
	
	
	
	
	
	

}
