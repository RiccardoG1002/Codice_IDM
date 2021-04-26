package com.corso.paesi;

import com.corso.dao.SinonimoDAO;
import com.corso.dao.SinonimoDAOImpl;
import com.corso.dao.StatAlgoritmoDAO;
import com.corso.dao.StatAlgoritmoDAOImpl;
import com.corso.exceptions.NotFoundException;

public class Admin {

	static void stampaPaesiDaApprovare() {
		SinonimoDAO dao = new SinonimoDAOImpl();
		for (Sinonimo s: dao.getSinonimiDaApprovare())
			System.out.println("cercata: " + s.getCercata() + " ---> "+ s.getPaese().toString());
	}
	
	static void approva(String cercata) {
		SinonimoDAO dao = new SinonimoDAOImpl();		
		Sinonimo sinonimo = null;
		try {
			sinonimo = dao.get(cercata);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		sinonimo.setApprovato(1);
		dao.update(sinonimo);
	}
	
	static void stampaStatsAlgoritmi() {
		StatAlgoritmoDAO dao = new StatAlgoritmoDAOImpl();
		for(StatAlgoritmo sa : dao.getStatsAlgoritmi())
			System.out.println(sa.toString());
	}

	
	
	
}
