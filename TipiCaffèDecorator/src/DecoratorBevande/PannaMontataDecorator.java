package DecoratorBevande;

import Bevande.Bevanda;

public class PannaMontataDecorator extends CaffeDecorator {

	public PannaMontataDecorator(Bevanda base) {
		super(base);
	}
	
	@Override
	public double prezzo() {
		return super.prezzo() + 0.20;
	}

}
