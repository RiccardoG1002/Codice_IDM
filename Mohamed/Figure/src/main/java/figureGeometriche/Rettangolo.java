package figureGeometriche;

public class Rettangolo extends Parallelogramma{
	
	private double altezza;
	private double base;
	
	public Rettangolo(double base, double altezza){
		super(base, altezza, altezza);
		this.altezza = altezza;
		this.base = base;
	}


}
