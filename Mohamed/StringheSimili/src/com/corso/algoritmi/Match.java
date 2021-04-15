package com.corso.algoritmi;

public class Match {
	private double score ;
	private String match;
	private boolean isBestMatch;
	
	public Match(String match, double score, boolean isBestMatch) {
		super();
		this.isBestMatch = isBestMatch;
		this.score = score;
		this.match = match;
	}

	
	public boolean isBestMatch() {
		return isBestMatch;
	}


	public double getScore() {
		return score;
	}
	
	public String getMatch() {
		return match;
	}
	
}
