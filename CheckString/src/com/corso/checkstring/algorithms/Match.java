package com.corso.checkstring.algorithms;

public class Match {
	
	private String match;
	private Algorithm algorithm;
	private int distance = -1;
	
	
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public Match(String match, Algorithm algorithm) {
		super();
		this.algorithm = algorithm;
		this.match = match;
	}
	
	


	public Match(String match, Algorithm algorithm, int distance) {
		super();
		this.match = match;
		this.algorithm = algorithm;
		this.distance = distance;
	}

	public String getMatch() {
		return match;
	}

	@Override
	public String toString() {
		return "Match [match=" + match + ", algorithm=" + algorithm +"]";
	}
	
	
}
