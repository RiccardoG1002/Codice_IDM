package Algoritmi;

public class UpperCase implements Algoritmo {

	@Override
	public double applica(String parola, String pattern) {
		String parolaCap = parola.substring(0, 1).toUpperCase() + parola.substring(1);
		if(pattern.contains(parolaCap)) return 100;
		return 0;
	}

}
