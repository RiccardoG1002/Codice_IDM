package com.corso.algoritmi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostSimilarString implements SimilarString{
	
	private SimilarString next= new LD();
	

	@Override
	public String similarString(String input, List<String> standard) {
		for(String s: standard) {
			if (s.contains(input)){
				return s;
			}
		 }
		
		if (getNext() != null)
			return getNext().similarString(input, standard);
		
		return null;
	}


	@Override
	public void setNext(SimilarString s) {
		this.next = next;
		
	}






	@Override
	public SimilarString getNext() {

		return next;
	}
	

}
