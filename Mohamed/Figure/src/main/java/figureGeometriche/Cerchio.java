package figureGeometriche;

public class Cerchio implements Figura {
	
	private double raggio;
	
	public Cerchio(double raggio){
		this.raggio = raggio;
	}

	@Override
	public double getArea() {
		return Math.PI * raggio * raggio;
	}

	@Override
	public double getPerimetro() {
		return 2*Math.PI*raggio;
	}

}
