package Exceptions;

public class NegozioInesistenteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NegozioInesistenteException() {
		super("Il negozio che hai selezionato non esiste!");
	}
}
