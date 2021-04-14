package decorator;

import java.util.Arrays;
import java.util.HashMap;

import figureGeometriche.Figura;

public abstract class FiguraDecorata implements Figura{
	private Figura figura;
	
	public FiguraDecorata(Figura figura) {
		super();
		this.figura = figura;
		
	}
	
	protected abstract HashMap<Proprieta, Object> getProprietaModificate();
	

	@Override
	public final double getArea() {
//		if (Arrays.stream(decorator).anyMatch(x -> x == Decorators.SPESSORE_BORDO) && getProprieta(Decorators.SPESSORE_BORDO) instanceof Double)
//			return figura.getArea() + (double) getProprieta(Decorators.SPESSORE_BORDO) ;
		return figura.getArea();
	}

	@Override
	public final double getPerimetro() {
		return figura.getPerimetro();
	}
	
	public final HashMap<Proprieta, Object> getProprieta() {
		HashMap<Proprieta, Object> proprieta = new HashMap<>();  
		
		if (figura instanceof FiguraDecorata)
			proprieta.putAll((((FiguraDecorata) figura).getProprietaModificate()));
		
		proprieta.putAll(getProprietaModificate());
		return proprieta;
	}
	
	public void stampaProprieta() {
		
		HashMap<Proprieta, Object> proprieta = getProprieta();
		for(Proprieta d: proprieta.keySet()) {
			System.out.println(d+ " " + proprieta.get(d));
		}
	}
	

}
