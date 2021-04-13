package DecoratorBevande;

import Bevande.Bevanda;

public abstract class CaffeDecorator implements Bevanda {
	
	private Bevanda base;
	
	public CaffeDecorator(Bevanda base) {
		this.base = base;
	}

	@Override
	public double prezzo() {
		return base.prezzo();
	}

}
