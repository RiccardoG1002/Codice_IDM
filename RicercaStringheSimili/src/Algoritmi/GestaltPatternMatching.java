package Algoritmi;

public class GestaltPatternMatching implements Algoritmo {

	@Override
	public double applica(String parola, String pattern) {
		int numberOfMatchingCharacters = numberOfMatchingCharacters(parola, pattern);
		double similarity = calculateSimilarity(parola.length(), pattern.length(), numberOfMatchingCharacters);
		return similarity * 100;
	}

	/**
	 * calcola il numero di caratteri uguali tra le due parole
	 * 
	 * @param parola:  parola inserita
	 * @param pattern: parola da confrontare
	 * @return numero di caratteri che matchano
	 */
	private int numberOfMatchingCharacters(String parola, String pattern) {
		int numberOfMatchingCharacters = 0;
		for (int i = 0; i < parola.length(); i++) {
			if (pattern.length() > i) {
				if (parola.charAt(i) == pattern.charAt(i)) {
					numberOfMatchingCharacters++;
				}
			}
		}
		return numberOfMatchingCharacters;
	}

	/**
	 * calcola il grado di similitutdine tra le due parole
	 * 
	 * @param parola:                     parola inserita
	 * @param pattern:                    parola da confrontare
	 * @param numberOfMatchingCharacters: nuero di caratteri uguali tra le due
	 *                                    parole
	 * @return grado di similitudine
	 */
	private double calculateSimilarity(int lunghezzaParola, int lunghezzaPattern, int numberOfMatchingCharacters) {
		return Double.valueOf(numberOfMatchingCharacters) / Double.valueOf(lunghezzaParola + lunghezzaPattern);
	}

}