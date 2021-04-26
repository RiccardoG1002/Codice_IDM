package com.corso.paesi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.corso.algoritmi.Levenshtein;
import com.corso.algoritmi.SimilarString;
import com.corso.algoritmi.SoundEx;

import com.corso.dao.DAO;
import com.corso.dao.PaeseDAO;
import com.corso.dao.PaeseDAOImpl;
import com.corso.dao.SinonimoDAO;
import com.corso.dao.SinonimoDAOImpl;
import com.corso.dizionario.DizionarioDaLocale;
import com.corso.exceptions.NotFoundException;
import com.corso.exceptions.PaeseNotFoundException;

import antlr.collections.List;
import test.TestStringhe;

public class PaeseTest {

	
	public static void main(String[] args) {
		
		menu();
		
		Admin.stampaStatsAlgoritmi();
		
		
	}
	
	private static void testGetNomi() {
		PaeseDAO paeseDAO = new PaeseDAOImpl();
		DizionarioDaLocale dizionarioDaLocale = new DizionarioDaLocale();
		
		for(String nomePaese: paeseDAO.getNomiPaesi())
			System.out.println(nomePaese);
	}


	
	private static void testGetSinonimo() {
		SinonimoDAOImpl sinDao = new SinonimoDAOImpl();
		try {
			sinDao.get("Italiaa");
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testGetAll() {
		PaeseDAO paeseDao = new PaeseDAOImpl();
		ArrayList<Paese> paesi = (ArrayList<Paese>) paeseDao.getAll();
		
		for(int i =0; i<10; i++)
			System.out.println(paesi.get(i).toString());
	}
	
	private static void testGetSinonimi() {
		ArrayList<Sinonimo> sinonimi = new ArrayList<Sinonimo>();
		PaeseDAO paeseDao = new PaeseDAOImpl();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Inserisci il codice del paese: ");
		String codice = sc.nextLine();
		try {
			for (Sinonimo s: paeseDao.get(codice).getSinonimi()) {
				System.out.println(s.getCercata());
			}
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private static void testInputUtente() {
		String cercata = "";
		Scanner sc= new Scanner(System.in); 
		System.out.println("Inserisci il nome di un paese: ");
		cercata = sc.nextLine();
		
		Paese p;
		try {
			p = new CheckPaese().getPaeseStandard(cercata);
			System.out.println(p.toString());
		} catch (PaeseNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	
	
	private static void menu() {
		String cercata = "";
		
		Scanner sc= new Scanner(System.in); 
		System.out.println("Inserisci p(cerca paese), s(sinonimi), b(break):");
		cercata = sc.nextLine();
		
		if(cercata.equals("b")) {
			System.out.println("Grazie!");
			return;
		}
		else if (cercata.equals("s"))
			testGetSinonimi();
		
		else if (cercata.equals("p"))
			testInputUtente();
			
		menu();
	}

}
