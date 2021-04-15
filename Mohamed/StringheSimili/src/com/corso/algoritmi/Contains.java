package com.corso.algoritmi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contains extends SimilarString{

	@Override
	Match getBestMatch(String input, List<String> standard) {
		for(String s: standard) {
			if (s.contains(input))
				return new Match(s, 1.0, true);
			
		 }
		
		return new Match(null, 0, false);

	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	
	
}
