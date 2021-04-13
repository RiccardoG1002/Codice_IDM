package DecoratorBevande;

import Bevande.Bevanda;

public class CaramelloDecorator extends CaffeDecorator {

	public CaramelloDecorator(Bevanda base) {
		super(base);
	}

	@Override
	public double prezzo() {
		return super.prezzo() + 0.60;
	}
}
