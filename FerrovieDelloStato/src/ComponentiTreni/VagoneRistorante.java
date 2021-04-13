package ComponentiTreni;

public abstract class VagoneRistorante extends Vagone {
	
	public final void controllaApertura() {
		this.controllaAperturaPersonalizzata();
	}
	
	protected abstract void controllaAperturaPersonalizzata();
	
}
