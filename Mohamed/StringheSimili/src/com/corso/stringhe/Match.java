package com.corso.stringhe;

public class Match {
	
	private String string;
	private int distance;
	

	public Match(String string, int distance) {
		super();
		this.string = string;
		this.distance = distance;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

}
