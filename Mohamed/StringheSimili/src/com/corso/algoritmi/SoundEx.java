package com.corso.algoritmi;

import java.util.List;

public class SoundEx implements SimilarString{
	
	private SimilarString next  = null;
	private int sogliaDistanzaMassima = 3;
	
	public void setSogliaDistanzaMassima(int sogliaDistanzaMassima) {
		this.sogliaDistanzaMassima = sogliaDistanzaMassima;
	}

	public SoundEx(){
		
	}

	public SoundEx(int ldSogliaDistanzaMassima){
		this.sogliaDistanzaMassima = ldSogliaDistanzaMassima;
	}
	
	
	public static String soundex(String s) {
		char[] x = s.toUpperCase().toCharArray();
		char firstLetter = x[0];

		//Convert letters to numeric code
		for (int i = 0; i < x.length; i++) {
		switch (x[i]) {
		case 'B', 'F', 'P', 'V':
		x[i] = '1';
		break;
		case 'C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z':
		x[i] = '2';
		break;
		case 'D', 'T':
		x[i] = '3';
		break;
		case 'L':
		x[i] = '4';
		break;
		case 'M', 'N':
		x[i] = '5';
		break;
		case 'R':
		x[i] = '6';
		break;
		default:
		x[i] = '0';
		break;
		}
		}

		String output = "" + firstLetter;

		for (int i = 1; i < x.length; i++) {
		if (x[i] != x[i - 1] && x[i] != '0') {
		output += x[i];
		}
		}

		output = output + "";
		return output;
		}

	@Override
	public SimilarString getNext() {
		return next;
	}

	@Override
	public String similarString(String input, List<String> standard) {
		
		int min_score = Integer.MAX_VALUE;
		String best_match = null;
		
		for(String s: standard) {
			
			int score = LD.compare(soundex(input), soundex(s));
			
			if(score < min_score) {
				best_match = s;
				min_score = score;
			}
		
		}
		
		if(min_score <= sogliaDistanzaMassima)
			return best_match;
				
		if(getNext() != null)
			return getNext().similarString(input, standard);
		
		return null;
	}

	@Override
	public void setNext(SimilarString s) {
		this.next = s;
	}

}
