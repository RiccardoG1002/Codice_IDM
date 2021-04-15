package com.corso.algoritmi;

import java.util.List;

public abstract class SimilarString {
	
	private SimilarString next = null, last = this;
	
	public final SimilarString getNext(){
		return this.next;
	}
	
	public final void setNext(SimilarString next) {
		this.next = next;
	}
	
	public final String getMostSimilar(String input, List<String> standard) {
		Match match = getBestMatch(input, standard);
		
		if(match.isBestMatch())
			return match.getMatch();
		
		if (!match.isBestMatch() && next !=null) {
			last = next;
			return next.getMostSimilar(input, standard);
		}
		return null;
	} 

	
	abstract Match getBestMatch(String input, List<String> standard);
	
	public final String getLastAlgo() {
		return last.toString();
	}
}