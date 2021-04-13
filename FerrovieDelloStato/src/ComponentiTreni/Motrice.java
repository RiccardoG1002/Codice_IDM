package ComponentiTreni;

public abstract class Motrice implements ComponenteTreno {

	@Override
	public final void stampa() {
		this.stampaPersonalizzata();
	}

	@Override
	public final double peso() {
		return this.pesoPersonalizzato();
	}

	/**
	 * ritorna il peso trainabile dalla motrice
	 * 
	 * @return {@value peso trainabile}
	 */
	public final double pesoTrainabile() {
		return this.pesoTrainabilePersonalizzato();
	}

	/**
	 * ritorna il peso trainabile dalla motrice, varia a seconda del tipo di motrice
	 * 
	 * @return {@value peso trainabile}
	 */
	protected abstract double pesoTrainabilePersonalizzato();

	/**
	 * ritorna il peso della motrice, varia a seconda del tipo di motrice
	 * 
	 * @return {@value peso della motrice}
	 */
	protected abstract double pesoPersonalizzato();

	/**
	 * stampa a video la motrice, varia a seconda del tipo di motrice
	 */
	protected abstract void stampaPersonalizzata();

}