package figureGeometriche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stella extends FiguraComposta{
	
	double dimensione;
	
	public Stella(double dim) {
		super(Arrays.asList(new Figura[]{new Triangolo(4*dim,1*dim), new Triangolo(4*dim,1*dim), new Triangolo(4*dim,1*dim), new Triangolo(4*dim,1*dim), new Triangolo(4*dim,1*dim), 
				new PoligonoRegolare(1*dim*0.688,1*dim,5)}));
		this.dimensione = dim;
		
	}

}
