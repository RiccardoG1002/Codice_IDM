package figureGeometriche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiguraComposta implements Figura{
	
	private List<Figura> figure;
	
	public FiguraComposta(List<Figura> figure){
		this.figure = figure.stream().sorted(Comparator.comparingDouble(Figura::getArea)).collect(Collectors.toList());
	}

	public FiguraComposta() {
		this.figure = new ArrayList<Figura>();
	}
	@Override
	public double getArea() {
		double area = 0.00;
		for (Figura f: figure) {
			area += f.getArea();
		}
		return area;
	}

	@Override
	public double getPerimetro() {
		return 0;
	}
	
	public void stampaAreaSottofigure() {
		for(Figura f:figure) {
			System.out.println(f.getArea());
		}
	}
	
	public void aggiungiFigura(Figura figura) {
		figure.add(figura);
		figure = figure.stream().sorted(Comparator.comparingDouble(Figura::getArea)).collect(Collectors.toList());
	}
	

}
