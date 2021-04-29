package com.corso.checkstring.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class Algorithm {
	private Algorithm next = null, last = this;
	
	public void setNext(Algorithm next) {
		this.next = next;
	}
	
	protected Algorithm getNext() {
		return next;
	}
	
	protected abstract Match checkString(String string, Collection<String> collection);
	
	public final Match getMostSimilar(String input, Collection<String> collection) {
		// convert strings to lowercase to help algos
		input = input.toLowerCase();
		collection = collection.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
		
		Match match = checkString(input, collection);
		
		if ((match == null || !match.isBestMatch()) && next !=null ) {
			last = next;
			return next.getMostSimilar(input, collection);
		}
		
		if(match.isBestMatch())
			return match;
		
		return null;
	} 

	public final String getLastAlgo() {
		return last.toString();
	}
}
