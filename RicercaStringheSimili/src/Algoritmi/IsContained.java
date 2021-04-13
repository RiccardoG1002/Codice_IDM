package Algoritmi;

public class IsContained implements Algoritmo {

	@Override
	public double applica(String parola, String pattern) {
		if(pattern.contains(parola)) return 100;
		return 0;
	}

}
