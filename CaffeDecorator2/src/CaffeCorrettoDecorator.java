
public class CaffeCorrettoDecorator implements Caffe {
	
	private Caffe base;
	private String liquore;
	
	public CaffeCorrettoDecorator(Caffe base, String liquore) {
		this.base = base;
		this.liquore = liquore;
	}

	@Override
	public void prepara() {
		base.prepara();
		System.out.println("Aggiungo: " + liquore);
	}

}
