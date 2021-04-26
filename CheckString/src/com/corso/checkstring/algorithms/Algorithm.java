package com.corso.checkstring.algorithms;

import java.util.ArrayList;

public abstract class Algorithm {
	private Algorithm next = null;
	
	public void setNext(Algorithm next) {
		this.next = next;
	}
	
	protected Algorithm getNext() {
		return next;
	}
	
	public abstract String checkString(String string, ArrayList<String> list);
}
