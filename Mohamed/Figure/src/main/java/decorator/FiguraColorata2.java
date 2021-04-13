package decorator;

import java.util.HashMap;

import figureGeometriche.Figura;

public class FiguraColorata2 extends FiguraDecorator2 {
	
	private String colore;
	
	public FiguraColorata2(Figura f, String colore) {
		super(f);
		this.colore = colore;
	}
	
	@Override
	protected HashMap<Proprieta, Object> getProprietaModificate() {
		// TODO Auto-generated method stub
		return null;
	}




}
