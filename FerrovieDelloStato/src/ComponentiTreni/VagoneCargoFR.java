package ComponentiTreni;

public class VagoneCargoFR extends VagoneCargo {

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("💼");
	}

	@Override
	protected double pesoAPienoCarico() {
		return 2850;
	}

}
