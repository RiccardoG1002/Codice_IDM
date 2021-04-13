package DecoratorBevande;

import Bevande.Bevanda;

public class WhiskeyDecorator extends CaffeDecorator {

	public WhiskeyDecorator(Bevanda base) {
		super(base);
	}
	
	@Override
	public double prezzo() {
		return super.prezzo() + 1.0;
	}

}
