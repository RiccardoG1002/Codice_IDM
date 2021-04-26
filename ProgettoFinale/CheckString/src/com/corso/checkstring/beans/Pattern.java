package com.corso.checkstring.beans;

public class Pattern implements BeanDTO {
	private String userPattern;
	private Country country;
	private String algorithm;
	private int approved; // -1 non approvata, 0 in attesa, +1 approvata
	
	public Pattern() {}
	public Pattern(String userPattern, Country country, String algorithm, int approved) {
		this.userPattern = userPattern;
		this.country = country;
		this.algorithm = algorithm;
		this.approved = approved;
	}
	
	public String getUserPattern() {
		return userPattern;
	}
	public void setUserPattern(String userPattern) {
		this.userPattern = userPattern;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
}
