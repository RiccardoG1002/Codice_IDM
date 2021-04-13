package com.corso.stringhe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.corso.algoritmi.LD;
import com.corso.algoritmi.LDAndContains;
import com.corso.algoritmi.StringComparingAlgo;

public class ConfrontaStringhe {
	
	private StringComparingAlgo algo;
	private static double SOGLIA = 15;
	public ConfrontaStringhe(double lunghezza_media){
		// controllo per scegliere un algoritmo 
		if (lunghezza_media < SOGLIA)
			this.algo = new LD();
		else 
			this.algo = new LDAndContains();
		
	}

	public StringComparingAlgo getAlgo() {
		return algo;
	}

	public int compare(String s, String t) {
		return algo.compare(s, t);		
	}
	
	public List<Match> compareWithMany(String source, Collection<String> strings) {
		
		List<Match> matches = new ArrayList<Match>();
		for(String s: strings) {
			matches.add(new Match(s, algo.compare(source, s)));
		}
		
		return matches.stream().sorted(Comparator.comparingInt(Match::getDistance)).collect(Collectors.toList());
	}
	

}
