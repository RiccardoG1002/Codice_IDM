package com.corso.checkstring.algorithms;

import java.util.ArrayList;
import java.util.Collection;


public class KMP extends Algorithm {
    public Match checkString(String string, Collection<String> list) {
		for(String s: list) {
			if(s.length() < string.length()) {
				System.out.println("Non sono riuscito con Knuth–Morris–Pratt...");
				return null;
			}
			
			char[] chars = string.toCharArray();
			
			int[] next = new int[string.length()+1];
			for(int i = 1; i < string.length(); i++) {
				int j = next[i+1];
				
				while(j > 0 && chars[j] != chars[i]) {
					j = next[j];
				}
				
				if(j > 0 || chars[j] == chars[i]) {
					next[i+1] = j+1;
				}
			}
			
			for(int i = 0, j = 0; i < s.length(); i++) {
				if(j < string.length() && s.charAt(i) == string.charAt(j)) {
					if(++j == string.length()) {
						System.out.println("Risolto con Knuth–Morris–Pratt!");
						return new Match(s, toString(),true);
					}
				}
				else if(j > 0) {
					j = next[j];
					i--;
				}
			}
		}
		
		System.out.println("Non sono riuscito con Knuth–Morris–Pratt...");
		
		if(getNext() != null) {
			return getNext().checkString(string, list);
		}
		else return null;
	}

	@Override
	public String toString() {
		return "KMP";
	}
    
}