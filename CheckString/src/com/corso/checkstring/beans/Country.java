package com.corso.checkstring.beans;

import java.util.Collection;
import java.util.List;

public class Country implements BeanDTO {
	private String code, name;
	private Collection<Pattern> patternList;
	private boolean fromApprovedSource;
	
	
	public Country() {}
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Pattern> getPatternList() {
		return patternList;
	}
	
	// private?
	public void setPatternList(Collection<Pattern> patternList) {
		this.patternList = patternList;
	}
	
	public boolean isFromApprovedSource() {
		return fromApprovedSource;
	}
	
	
	public void setFromApprovedSource(boolean fromApprovedSource) {
		this.fromApprovedSource = fromApprovedSource;
	}
	
	
}
