package DecoratorBevande;

import Bevande.Bevanda;

public class CacaoDecorator extends CaffeDecorator {

	public CacaoDecorator(Bevanda base) {
		super(base);
	}
	
	@Override
	public double prezzo() {
		return super.prezzo() + 0.10;
	}

}
