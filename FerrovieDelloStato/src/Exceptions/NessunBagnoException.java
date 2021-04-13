package Exceptions;

public class NessunBagnoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NessunBagnoException() {
		super("In questo treno manca il bagno!");
	}
}
