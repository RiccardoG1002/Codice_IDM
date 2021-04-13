package ComponentiTreni;

public class VagonePasseggeriFR extends VagonePasseggeri {

	private int postiOccupati;

	@Override
	protected void stampaPersonalizzata() {
		System.out.print("😴");
	}

	@Override
	protected void aggiungiPasseggeriPersonalizzato(int numeroPasseggeri) {
		this.postiOccupati = this.postiOccupati + numeroPasseggeri;
	}

	@Override
	protected double pesoPersoneTrasportate() {
		return 70 * postiOccupati;
	}

	@Override
	protected int capienzaPersonalizzata() {
		return 80 - postiOccupati;
	}

	@Override
	protected double pesoMassimoPersonalizzato() {
		return 80 * 70;
	}

}