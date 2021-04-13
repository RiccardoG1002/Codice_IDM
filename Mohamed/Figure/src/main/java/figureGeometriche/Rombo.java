package figureGeometriche;

public class Rombo extends Parallelogramma {

	private double diag1, diag2;
	
	public Rombo(double diag1, double diag2) {
		super(Math.sqrt(((diag2/2)*(diag2/2))+((diag1/2)*(diag1/2))), Math.sqrt(((diag2/2)*(diag2/2))+((diag1/2)*(diag1/2))),1);
		this.diag1 = diag1;
		this.diag2 = diag2;
	}
	
	@Override
	public double getArea() {
		return diag1*diag2/2;
	}
	
	

}
