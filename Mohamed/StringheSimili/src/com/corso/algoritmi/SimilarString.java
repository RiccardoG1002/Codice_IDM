package com.corso.algoritmi;

import java.util.List;

public interface SimilarString {
	
	SimilarString getNext();
	String similarString(String input, List<String> standard); 
	void setNext(SimilarString s);

}
