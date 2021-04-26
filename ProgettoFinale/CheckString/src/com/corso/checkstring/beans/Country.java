package com.corso.checkstring.beans;

import java.util.List;

public class Country implements BeanDTO {
	private String code, name;
	private List<Pattern> patternList;
	
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
	public List<Pattern> getPatternList() {
		return patternList;
	}
	
	// private?
	public void setPatternList(List<Pattern> patternList) {
		this.patternList = patternList;
	}
}
