package Exceptions;

public class TroppiPasseggeriException extends Exception {
	private static final long serialVersionUID = 1L;

	public TroppiPasseggeriException(int capienzaMax) {
		super("Questo vagone ha una capienza massima di: " + capienzaMax + " persone!");
	}
}
