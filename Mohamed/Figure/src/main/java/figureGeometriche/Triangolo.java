package figureGeometriche;

public class Triangolo implements Figura {
	
   private double altezza, base;

    Triangolo(double altezza, double base){
    	this.altezza = altezza;
    	this.base = base;
    }
    
	@Override
	public double getArea() {
		return 0.5 * base * altezza;
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

}
