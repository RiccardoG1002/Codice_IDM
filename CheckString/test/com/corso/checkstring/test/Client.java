package com.corso.checkstring.test;

import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.base.Controller;
import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.StatAlgoritmo;
import com.corso.checkstring.dao.StatAlgoritmoDAOImpl;

public class Client {

	public static void main(String[] args) {
//		String find = "Itaia";
//		
//		Controller c = new Controller();
//		
///		Country result = c.checkString(find, new Levenshtein());
//		System.out.println("Parola inserita: " + find);
//		System.out.println(result.getName());
//		
	  for (StatAlgoritmo s : new StatAlgoritmoDAOImpl().getStatsAlgoritmi())
		  System.out.println(s.getAlgoritmo());
	}
}
