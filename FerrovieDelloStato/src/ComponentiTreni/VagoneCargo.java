package ComponentiTreni;

public abstract class VagoneCargo extends Vagone {
	
	private double percentualeRiempita;
	
	@Override
	protected final double pesoPersonalizzato() {
		return this.pesoAPienoCarico() * percentualeRiempita;
	}
	
	protected abstract double pesoAPienoCarico();
}