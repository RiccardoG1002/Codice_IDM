package ComponentiTreni;

public abstract class VagoneBagno extends Vagone {
	public final void pulisci() {
		this.pulisciPersonalizzato();
	}
	
	protected abstract void pulisciPersonalizzato();
}
