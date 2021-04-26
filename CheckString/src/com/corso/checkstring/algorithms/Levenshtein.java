package com.corso.checkstring.algorithms;

import java.util.ArrayList;

public class Levenshtein extends Algorithm {
	/* Restituisce il massimo tra |i| e |j| */
    private int max(int i, int j) {
        return (i>j ? i : j);
    }

    /* Restituisce il minimo tra |i|, |j| e |k| */
    private int min3(int i, int j, int k) {
        int min = i;
        if (j < min) min = j;
        if (k < min) min = k;
        return min;
    }

    /*
     * Restituisce la distanza di Levenshtein tra due stringhe.
     * La distanza è un intero compreso tra 0 e la massima
     * lunghezza delle due stringhe.
     */     
    @Override
    public String checkString(String string, ArrayList<String> list) {
    	int minDistanceFound = -1;
    	String result = null;
    	
    	for(String s: list) {
    		
            int i, j;
            final int n = string.length(), m = s.length();
            int L[][] = new int[n+1][m+1];
            for (i=0; i<n+1; i++) {
                for (j=0; j<m+1; j++) {
                    if (i==0 || j==0) {
                        L[i][j] = max(i, j);
                    }
                    else {
                        L[i][j] = min3(L[i-1][j] + 1, L[i][j-1] + 1,
                                       L[i-1][j-1] + (string.charAt(i-1) != s.charAt(j-1) ? 1 : 0));
                    }
                }
            }

            /*
            // Stampa la matrice L
            for (i=0; i<n+1; i++) {
                for (j=0; j<m+1; j++) {
                    System.out.print(L[i][j]);
                }
                System.out.println();
            }
            */
            
            if(minDistanceFound == -1) {
            	minDistanceFound = L[n][m];
            	result = s;
            }
            else if(L[n][m] < minDistanceFound) {
            	minDistanceFound = L[n][m];
            	result = s;
            }
    	}
    	
    	if(minDistanceFound >= 2) {
    		System.out.println("Non sono riuscito con Levenshtein...");
    		if(getNext() != null) {
    			return getNext().checkString(string, list);
    		}
    		else return null;
    	}
    	else {
    		System.out.println("Risolto con Levenshtein!");
    		return result+"$"+this.toString();
    	}
    }

	@Override
	public String toString() {
		return "Levenshtein";
	}

}