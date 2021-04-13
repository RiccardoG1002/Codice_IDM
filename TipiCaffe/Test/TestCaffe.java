import Caffe.AbstractCaffe;
import Caffe.Cappuccino;
import Caffe.Espresso;
import Caffe.IrishCoffee;
import Elettrodomestici.Microonde;

public class TestCaffe {

	public static void main(String[] args) {
		AbstractCaffe caffe = new IrishCoffee();
		caffe.descrizione();
		System.out.println("L'Irish Coffee costa: " + caffe.prezzo() + " $\n");
		caffe = new Cappuccino();
		caffe.descrizione();
		System.out.println("Il Cappuccino costa: " + caffe.prezzo() + " $\n");
		caffe = new Espresso();
		caffe.descrizione();
		System.out.println("L'Espresso costa: " + caffe.prezzo() + " $\n");
		Microonde m = new Microonde();
		m.riscalda(caffe);
	}

}
