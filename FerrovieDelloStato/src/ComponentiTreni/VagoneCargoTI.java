package ComponentiTreni;

public class VagoneCargoTI extends VagoneCargo {

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("📦");
	}

	@Override
	protected double pesoAPienoCarico() {
		return 3000;
	}

}
