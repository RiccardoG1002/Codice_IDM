package com.corso.algo;

import java.util.Collection;
import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class TopTreAlgoritmo {
	
	public LinkedList<Integer> order(Collection<Integer> integers) {
		
		if(integers.size() < 3) throw new RuntimeErrorException(null, "size < 3!!!");
		
		// svantaggio: i confronti con MIN_VALUE e MAX_VALUE comportano un costo maggiore
		int  primo = Integer.MIN_VALUE, secondo = Integer.MIN_VALUE, terzo = Integer.MIN_VALUE;
				
	    for(int e: integers){
	       
	        if (e > primo){
	        
	        	terzo = secondo;
	        	secondo = primo;
	            primo = e;
	        }
	        else if (e > secondo){        	
	        	
	            terzo = secondo;
	            secondo = e;
	        }
	        else if (e > terzo)
	            terzo = e;
	    
	    }
	    
	    LinkedList<Integer> result = new LinkedList<>();
	    result.add(primo);
	    result.add(secondo);
	    result.add(terzo);
	    
		return result;
		
	}
		
	
}
