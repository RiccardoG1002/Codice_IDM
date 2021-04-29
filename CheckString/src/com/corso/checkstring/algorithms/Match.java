package com.corso.checkstring.algorithms;

public class Match {
	
	private String match;
	private String algorithm;
	private boolean isBestMatch;
	
	
	public String getAlgorithm() {
		return algorithm;
	}

	public Match(String match, String algorithm, boolean isBestMatch) {
		super();
		this.algorithm = algorithm;
		this.isBestMatch = isBestMatch;
		this.match = match;
	}

	
	public boolean isBestMatch() {
		return isBestMatch;
	}

	public String getMatch() {
		return match;
	}

	@Override
	public String toString() {
		return "Match [match=" + match + ", algorithm=" + algorithm + ", isBestMatch=" + isBestMatch + "]";
	}
	
	
}
