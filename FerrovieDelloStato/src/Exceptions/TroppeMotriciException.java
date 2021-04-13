package Exceptions;

public class TroppeMotriciException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TroppeMotriciException() {
		super("In questo treno ci sono troppe motrici!");
	}

}
