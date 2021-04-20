package com.corso.algoritmi;

import java.util.Collection;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class SimilarString {
	
	private SimilarString next = null, last = this;
	
	public final SimilarString getNext(){
		return this.next;
	}
	
	public final void setNext(SimilarString next) {
		this.next = next;
	}
	
	public final Match getMostSimilar(String input, Collection<String> collection) {
		// convert strings to lowercase to help algos
		input = input.toLowerCase();
		collection = collection.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
		
		Match match = getBestMatch(input, collection);
		
		if ((match == null || !match.isBestMatch()) && next !=null ) {
			last = next;
			return next.getMostSimilar(input, collection);
		}
		
		if(match.isBestMatch())
			return match;
		
		return null;
	} 

	
	abstract Match getBestMatch(String input, Collection<String> collection);
	
	public final String getLastAlgo() {
		return last.toString();
	}
}