
public class ZuccheroDecorator implements Caffe {
	
	public Caffe base;
	
	public ZuccheroDecorator(Caffe base) {
		this.base = base;
	}

	@Override
	public void prepara() {
		base.prepara();
		System.out.println("Ci aggiungo un po' di zucchero");
	}

}
