package Exceptions;

public class PesoEccessivoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PesoEccessivoException() {
		super("Il treno pesa troppo, la motrice non sarebbe in grado di trainarlo!");
	}

}
