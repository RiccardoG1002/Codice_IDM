package Confronto;

import Algoritmi.Algoritmo;
import Algoritmi.GestaltPatternMatching;
import Algoritmi.IsContained;
import Algoritmi.UpperCase;

public class Comparatore {

	private static Algoritmo algoritmo;

	/**
	 * applica l'algoritmo di confronto
	 * 
	 * @param parola:  parola inserita
	 * @param pattern: parola da confrontare
	 * @return il grado di similitutdine tra le parole confrontate
	 */
	public static double confronta(String parola, String pattern) {
		scegliAlgoritmo(parola, pattern);
		return algoritmo.applica(parola, pattern) / 100;
	}

	/**
	 * sceglie l'algoritmo di confronto da applicare
	 * 
	 * @param parola:  parola inserita
	 * @param pattern: parola da confrontare
	 */
	private static final void scegliAlgoritmo(String parola, String pattern) {
		if (isUpperCase(parola)) {
			algoritmo = new IsContained();
			if (algoritmo.applica(parola, pattern) == 0) {
				algoritmo = new GestaltPatternMatching();
			}
		} else {
			algoritmo = new UpperCase();
			if (algoritmo.applica(parola, pattern) == 0) {
				algoritmo = new GestaltPatternMatching();
			}
		}
	}

	/**
	 * controlla se la prima lettera della parola inserita è maiuscola
	 * 
	 * @param parola parola inserita
	 * @return
	 */
	private static final boolean isUpperCase(String parola) {
		String capParola = parola.substring(0, 1).toUpperCase() + parola.substring(1);
		if (parola.equals(capParola))
			return true;
		return false;
	}

}
