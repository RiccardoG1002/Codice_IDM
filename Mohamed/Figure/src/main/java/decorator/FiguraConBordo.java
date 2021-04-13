package decorator;

import java.util.HashMap;

import figureGeometriche.Figura;

public class FiguraConBordo extends FiguraDecorata{
	
	private String colore;
	private double spessore;
	
	public FiguraConBordo(Figura figura, double spessore, String colore) {
		super(figura);
		this.colore = colore;
		this.spessore = spessore;
	}

	public double getSpessore() {
		return spessore;
	}

	public void setSpessore(double spessore) {
		this.spessore = spessore;
	}

	public String getColore() {
		return this.colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	protected HashMap<Proprieta, Object> getProprietaModificate() {
		HashMap<Proprieta, Object> proprieta = new HashMap<>();
		proprieta.put(Proprieta.COLORE_BORDO, colore);
		proprieta.put(Proprieta.SPESSORE_BORDO, spessore);
		
		return proprieta;
	}
	
	

}
