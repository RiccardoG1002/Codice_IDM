
public class Decaffeinato implements Caffe {

	private String miscela;

	public Decaffeinato(String miscela) {
		this.miscela = miscela;
	}

	@Override
	public void prepara() {
		System.out.println("Preparo un caff� decaffeinato usando la miscela: " + miscela);
	}

}
