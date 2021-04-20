package com.corso.algoritmi;

import java.util.Collection;

public class Gestallt  extends SimilarString{
	
	

	@Override
	Match getBestMatch(String input, Collection<String> collection) {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected final String applyMyAlgorithm(String input, String string) {
		int sameCharactes = this.matchingCharacters(input, string);
		double similarity = this.calculateSimilarity(sameCharactes, input.length(), string.length());
		
	//	if(similarity > this.threshold()) return string;
		
		return null;
	}
	
	private int matchingCharacters(String input, String string) {
		int sameCharacters = 0;
		for (int i = 0; i < input.length(); i++) {
			if (string.length() > i) {
				if (input.charAt(i) == string.charAt(i)) {
					sameCharacters++;
				}
			}
		}
		return sameCharacters;
	}
	
	private final double calculateSimilarity(int sameCharachtes, int inputLength, int stringLength) {
		return Double.valueOf(sameCharachtes) / Double.valueOf(inputLength + stringLength);
	}
	

	@Override
	public String toString() {
		return this.getClass().getSimpleName(); //+ maxDistance;
	}
	
	

}
