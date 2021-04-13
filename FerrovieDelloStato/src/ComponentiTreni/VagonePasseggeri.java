package ComponentiTreni;

public abstract class VagonePasseggeri extends Vagone {
	
	public final void aggiungiPassegggeri(int numeroPasseggeri) {
		this.aggiungiPasseggeriPersonalizzato(numeroPasseggeri);
	}
	
	protected abstract void aggiungiPasseggeriPersonalizzato(int numeroPasseggeri);
	
	public final int capienzaVagone() {
		return this.capienzaPersonalizzata();
	}
	
	protected abstract int capienzaPersonalizzata();
	
	@Override
	protected final double pesoPersonalizzato() {
		return 1000 + this.pesoPersoneTrasportate();
	}
	
	protected abstract double pesoPersoneTrasportate();
	
	public final double pesoMassimo() {
		return 1000 + this.pesoMassimoPersonalizzato();
	}
	
	protected abstract double pesoMassimoPersonalizzato();
}