package figureGeometriche;

public class Trapezio extends Quadrilatero {
	private double altezza, base1, base2, lato_obliquo1, lato_obliquo2;
	
	public Trapezio(double base1, double base2, double lato_obliquo1, double lato_obliquo2, double altezza) {
		super(new Double[] {base1,base2,lato_obliquo1, lato_obliquo2}, null);
		this.altezza = altezza;
		this.base1 = base1;
		this.base2 = base2;
		this.lato_obliquo1 = lato_obliquo1;
		this.lato_obliquo2 = lato_obliquo2;
	}
	
	public Trapezio(double base1, double base2, double altezza) {
		// Modificare!
		super(new Double[] {base1,base2,0.00,0.00}, null);
		this.altezza = altezza;
		this.base1 = base1;
		this.base2 = base2;
		
	}
	@Override
	public double getArea() {
		return ((base1+base2)*altezza)/2;
	}

	

}
