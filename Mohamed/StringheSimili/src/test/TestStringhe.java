package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.corso.algoritmi.LD;
import com.corso.algoritmi.MostSimilarString;
import com.corso.algoritmi.SimilarString;
import com.corso.algoritmi.SoundEx;
import com.corso.stringhe.ConfrontaStringhe;
import com.corso.stringhe.Match;


public class TestStringhe {
	
	private static List<String> fromFile(String file){ 
		List<String> strings = new ArrayList<String>();
		try {
	      File myObj = new File(file);
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
		return strings;
	}
	
	public static void main(String[] vars) {
		
	
		
		List<String> list = fromFile("countries.txt");
		
		
		
		SimilarString s1 = new SoundEx(1);
		SimilarString s2 = new SoundEx(2);
		SimilarString s3 = new SoundEx(3);
		
		s1.setNext(s2);
		s2.setNext(s3);
		
		System.out.println("Best match: "+ s1.similarString("Italia", list));
		
		
	
		
		
	}

}
