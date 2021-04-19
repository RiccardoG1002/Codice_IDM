package com.corso.paesi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.corso.algoritmi.SimilarString;
import com.corso.algoritmi.SoundEx;
import com.corso.dao.PaeseDAO;
import com.corso.dao.PaeseDAOImpl;
import com.corso.dao.SinonimoDAO;
import com.corso.dizionario.DizionarioDaLocale;

import antlr.collections.List;
import test.TestStringhe;

public class PaeseTest {
	private static final String beans_stringhe = "beans/beans_stringhe.xml";
	
	public static void main(String[] args) {
		 
	//	Scanner sc= new Scanner(System.in); 
	//	String cercata = sc.nextLine();
		
		testGetAll();

	}
	
	private static void testGetNomi() {
		PaeseDAO paeseDAO = new PaeseDAOImpl();
		DizionarioDaLocale dizionarioDaLocale = new DizionarioDaLocale();
		
		for(String nomePaese: paeseDAO.getNomiPaesi())
			System.out.println(nomePaese);
	}

//	private static void testInserimentoSinonimi(String cercata) {
//		SinonimoDAOImpl sinonimiDao = new SinonimoDAOImpl();
//		Sinonimo dbRisultato = sinonimiDao.get(cercata);
//		
//		if (dbRisultato == null) {
//			
//			Paese p = new Paese();
//			p.setCodice("AF");
//			
//			Sinonimo sinonimo = new Sinonimo();
//			sinonimo.setCercata(cercata);
//			sinonimo.setPaese(p);
//			sinonimo.setAlgoritmo("soundex2");
//			
//			sinonimiDao.save(sinonimo);
//			
//			
//			
//		}else {
//			
//			dbRisultato.increment();
//			sinonimiDao.update(dbRisultato);
//		}
//	}
//	
//	private static void testGetSinonimo() {
//		SinonimoDAOImpl sinDao = new SinonimoDAOImpl();
//		
//		
//	}
//	
//	private static void testCheckStringBeans() {
//		ApplicationContext context =  new ClassPathXmlApplicationContext(beans_stringhe);
//		SimilarString similarString = (SimilarString) context.getBean("checkString");
//		System.out.println(similarString.getMostSimilar("Italia", TestStringhe.fromFile("src/main/resources/countries.txt")));
//	}
//	
	private static void testGetAll() {
		 PaeseDAO paeseDao = new PaeseDAOImpl();
		ArrayList<Paese> paesi = (ArrayList<Paese>) paeseDao.getAll();
		
		for(int i =0; i<10; i++)
			System.out.println(paesi.get(i).toString());
	}
}
