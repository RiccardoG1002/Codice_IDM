
public class TestCaffe {

	public static void main(String[] args) {
		Caffe caffe = new Espresso("Arabica");
		caffe = new CaffeCorrettoDecorator(caffe, "sambuca");
		caffe = new ZuccheroDecorator(caffe);
		caffe.prepara();
		caffe = new CaffeCorrettoDecorator(caffe, "whiskey");
		caffe.prepara();
	}

}
