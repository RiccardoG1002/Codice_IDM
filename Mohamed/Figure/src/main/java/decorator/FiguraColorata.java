package decorator;

import java.util.HashMap;

import figureGeometriche.Figura;

public class FiguraColorata extends FiguraDecorata{
	
	private String colore;
	
	public FiguraColorata(Figura figura, String colore) {
		super(figura);
		this.colore = colore;
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
		proprieta.put(Proprieta.COLORE_RIEMPIMENTO, colore);
		return proprieta;
	}
	
}
