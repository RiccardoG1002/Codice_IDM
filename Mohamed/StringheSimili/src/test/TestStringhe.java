package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.corso.algoritmi.LD;
import com.corso.stringhe.ConfrontaStringhe;
import com.corso.stringhe.Match;


public class TestStringhe {
	
	public static void main(String[] vars) {
		
		List<String> strings = new ArrayList<String>();
		
		try {
		      File myObj = new File("countries.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        strings.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		
		ConfrontaStringhe cs = new ConfrontaStringhe(19.00);
		
		List<Match> list = cs.compareWithMany("Italia", strings);
		
		System.out.println("Best match: "+ list.get(0).getString());
	
		
		
	}

}
