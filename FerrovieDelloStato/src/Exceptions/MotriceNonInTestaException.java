package Exceptions;

public class MotriceNonInTestaException extends Exception {

	private static final long serialVersionUID = 1L;

	public MotriceNonInTestaException() {
		super("La prima carrozza del treno deve esseere una motrice!");
	}
}
