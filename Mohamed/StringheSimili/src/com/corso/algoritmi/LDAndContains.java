package com.corso.algoritmi;

public class LDAndContains extends LD {

	@Override
	public int compare(String s, String t) {
		if (s.contains(t))
			return super.compare(s, t) * 8/10;
		
		return super.compare(s, t);
	}
	
	

}
