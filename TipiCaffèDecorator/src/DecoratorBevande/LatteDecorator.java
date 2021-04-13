package DecoratorBevande;

import Bevande.Bevanda;

public class LatteDecorator extends CaffeDecorator {

	public LatteDecorator(Bevanda base) {
		super(base);
	}
	
	@Override
	public double prezzo() {
		return super.prezzo() + 0.5;
	}

}
