package figureGeometriche;

import java.util.Comparator;

public interface Figura extends Comparable<Figura>{
	
	public double getArea();
	public double getPerimetro();
	
	
	
	@Override
	default int compareTo(Figura o) {
		
		return  Double.valueOf(this.getArea()).compareTo(o.getArea());
	}
	
	
	
	
	
	
}
