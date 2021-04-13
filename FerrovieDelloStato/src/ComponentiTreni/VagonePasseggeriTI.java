package ComponentiTreni;

public class VagonePasseggeriTI extends VagonePasseggeri {

	private int postiOccupati;

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("😩");
	}

	@Override
	protected void aggiungiPasseggeriPersonalizzato(int numeroPasseggeri) {
		this.postiOccupati = numeroPasseggeri;
	}

	@Override
	protected double pesoPersoneTrasportate() {
		return 70 * postiOccupati;
	}

	@Override
	protected int capienzaPersonalizzata() {
		return 100 - postiOccupati;
	}

	@Override
	protected double pesoMassimoPersonalizzato() {
		return 100 * 70;
	}

}
