package com.corso.checkstring.algorithms;

import java.util.ArrayList;
import java.util.Collection;

public class Contains extends Algorithm<Match>{
	
	@Override
	public Match checkString(String string, Collection<String> list) {
		
		// Devo fare un contains() per ogni singola parola della stringa e non su tutta.
		// Controllo se ci sono degli spazzi e divido in diverse parole.
		
		for(String s: list) {
			if(s.contains(string)) {
				System.out.println("Risolto con Contains!");
				new Match(s, this);
			}
		}
	
		 return null;
	}

	@Override
	public String toString() {
		return "Contains";
	}

}
