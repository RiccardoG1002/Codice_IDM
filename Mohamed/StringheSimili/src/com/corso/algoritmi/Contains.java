package com.corso.algoritmi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Contains extends SimilarString{

	@Override
	Match getBestMatch(String input, Collection<String> standard) {
		for(String s: standard) {
			if (s.contains(input))
				return new Match(s, toString(), true);
			
		 }
		
		return new Match(null, toString(), false);

	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	
	
}
