package com.corso.checkstring.algorithms;

public class Match {
	
	private String match;
	private CountryAlgorithm algorithm;
	private int distance = -1;
	
	
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public CountryAlgorithm getAlgorithm() {
		return algorithm;
	}

	public Match(String match, CountryAlgorithm algorithm) {
		super();
		this.algorithm = algorithm;
		this.match = match;
	}
	
	


	public Match(String match, CountryAlgorithm algorithm, int distance) {
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
