package com.corso.checkstring.test;

import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.base.ControllerCheckString;
import com.corso.checkstring.beans.Country;

public class Client {

	public static void main(String[] args) {
		String find = "Itaia";
		
		ControllerCheckString c = new ControllerCheckString();
		
		Country result = c.checkString(find, new Levenshtein());
		System.out.println("Parola inserita: " + find);
		System.out.println(result.getName());
		
	}
}
