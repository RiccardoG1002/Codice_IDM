import Bevande.Bevanda;
import Bevande.Espresso;
import Bevande.IrishCoffee;
import DecoratorBevande.CaramelloDecorator;
import DecoratorBevande.LatteDecorator;

public class BevandeTest {

	public static void main(String[] args) {
		Bevanda espresso = new Espresso();
		System.out.println("L'espresso costa: " + espresso.prezzo());
		espresso = new LatteDecorator(espresso);
		System.out.println("Il cappuccino costa: " + espresso.prezzo());
		espresso = new CaramelloDecorator(espresso);
		System.out.println("Il cappuccino con il caramello costa: " + espresso.prezzo());
		espresso = new IrishCoffee();
		espresso = new CaramelloDecorator(espresso);
		System.out.println("L'Irish Coffe con il caramello costa: " + espresso.prezzo());
	}

}
