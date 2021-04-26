package com.corso.checkstring.algorithms;

import java.util.ArrayList;

public class Contains extends Algorithm {
	
	@Override
	public Match checkString(String string, ArrayList<String> list) {
		
		// Devo fare un contains() per ogni singola parola della stringa e non su tutta.
		// Controllo se ci sono degli spazzi e divido in diverse parole.
		
		for(String s: list) {
			if(s.contains(string)) {
				System.out.println("Risolto con Contains!");
				new Match(s, toString(),true);
			}
		}
		
		System.out.println("Non sono riuscito con Contains...");
		
		if(getNext() != null) {
			return getNext().checkString(string, list);
		}
		else return null;
	}

	@Override
	public String toString() {
		return "Contains";
	}

}
