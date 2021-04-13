
public class Espresso implements Caffe {
	
	private String miscela;
	
	public Espresso(String miscela) {
		this.miscela = miscela;
	}

	@Override
	public void prepara() {
		System.out.println("Preparo un caff� espresso con la miscela: " + miscela);
	}

}
