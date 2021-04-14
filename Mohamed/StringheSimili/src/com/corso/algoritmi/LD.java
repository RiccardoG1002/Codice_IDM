package com.corso.algoritmi;

import java.util.List;

public class LD implements SimilarString{
	
	private SimilarString next = new SoundEx();
	
	 public LD(){
		 
	 }

	  //****************************
	  // Get minimum of three values
	  //****************************
	
	  private static int minimum (int a, int b, int c) {
	  int mi;
	
	    mi = a;
	    if (b < mi) {
	      mi = b;
	    }
	    if (c < mi) {
	      mi = c;
	    }
	    return mi;
	
	  }
	
	  //*****************************
	  // Compute Levenshtein distance
	  //*****************************
	

	public static int compare(String s, String t) {
		 int d[][]; // matrix
		  int n; // length of s
		  int m; // length of t
		  int i; // iterates through s
		  int j; // iterates through t
		  char s_i; // ith character of s
		  char t_j; // jth character of t
		  int cost; // cost
	
		// Step 1
	
	    n = s.length ();
	    m = t.length ();
	    if (n == 0) {
	      return m;
	    }
	    if (m == 0) {
	      return n;
	    }
	    d = new int[n+1][m+1];
	
	    // Step 2
	
	    for (i = 0; i <= n; i++) {
	      d[i][0] = i;
	    }
	
	    for (j = 0; j <= m; j++) {
	      d[0][j] = j;
	    }
	
	    // Step 3
	
	    for (i = 1; i <= n; i++) {
	
	      s_i = s.charAt (i - 1);
	
	      // Step 4
	
	      for (j = 1; j <= m; j++) {
	
	        t_j = t.charAt (j - 1);
	
	        // Step 5
	
	        if (s_i == t_j) {
	          cost = 0;
	        }
	        else {
	          cost = 1;
	        }
	
	        // Step 6
	
	        d[i][j] = minimum (d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1] + cost);
	
	      }
	
	    }
	
	    // Step 7
	
	    return d[n][m];
	}

	
	@Override
	public SimilarString getNext() {
		return next;
	}
	
	

	@Override
	public String similarString(String input, List<String> standard) {
		int min_score = Integer.MAX_VALUE;
		String best_match = null;
		
		for(String s: standard) {
			int score = compare(input, s);
			
			if(score < min_score) {
				best_match = s;
				min_score = score;
			}
		}
		
		if(min_score <= 2)
			return best_match;
			
		return getNext().similarString(input, standard);
	}

	@Override
	public void setNext(SimilarString s) {
		this.next = s;
		
	}

	

}


