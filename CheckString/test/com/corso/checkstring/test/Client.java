package com.corso.checkstring.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.corso.checkstring.algorithms.CheckDatabase;
import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.algorithms.Match;
import com.corso.checkstring.algorithms.SoundEx;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.StatAlgoritmo;
import com.corso.checkstring.dao.StatAlgoritmoDAOImpl;

public class Client {

	public static void main(String[] args) {

		testChain();
		
	}
	
	private static void testChain() {
		CheckDatabase cd = new CheckDatabase();
		Levenshtein l1 = new Levenshtein();
		SoundEx soundEx = new SoundEx();
		
		cd.setNext(l1);
		l1.setNext(soundEx);
		
		
		
	//	List<String> standard = Arrays.asList("Netherlands", "United states", "South Africa", "Italy");
    //		String testWord = "Itali";
		
		Country m = l1.getMostSimilarCountry("agna");
		
		
		System.out.println(m.toString());
		
	}
	
	private static void oldTest() {
		// ControllerCheckString c = new ControllerCheckString();
		
//		Country result = c.checkString(find, new Levenshtein());
//		System.out.println("Parola inserita: " + find);
//		System.out.println(result.getName());
//		
//			String find = "Itaia";
//			
//			Controller c = new Controller();
//			
//			Country result = c.checkString(find, new Levenshtein());
//			System.out.println("Parola inserita: " + find);
//			System.out.println(result.getName());
//		
//	  for (StatAlgoritmo s : new StatAlgoritmoDAOImpl().getStatsAlgoritmi())
//		  System.out.println(s.getAlgoritmo());
	}

}
