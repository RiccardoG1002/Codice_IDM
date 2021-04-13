
public class CaffeConPanna implements Caffe {
	
	private Caffe base;
	
	public CaffeConPanna(Caffe base) {
		this.base = base;
	}

	@Override
	public void prepara() {
		base.prepara();
		System.out.println("Aggiungo della panna");
	}

}
