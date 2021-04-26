package com.corso.paesi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.corso.algoritmi.Match;
import com.corso.algoritmi.SimilarString;
import com.corso.dao.PaeseDAOImpl;
import com.corso.dao.SinonimoDAO;
import com.corso.dao.SinonimoDAOImpl;
import com.corso.dizionario.Dizionario;
import com.corso.dizionario.DizionarioDaDb;
import com.corso.exceptions.NotFoundException;
import com.corso.exceptions.PaeseNotFoundException;

import test.TestStringhe;

public class CheckPaese {
	private static final String beans_stringhe = "beans/beans_stringhe.xml";
	private Dizionario standard = new DizionarioDaDb();
	
	public CheckPaese() {
		
	}
	
	public void setStandard(Dizionario standard) {
		this.standard = standard;
	}

	public Paese getPaeseStandard(String cercata) throws PaeseNotFoundException {
		
		SinonimoDAO sinonimiDao = new SinonimoDAOImpl();
		Sinonimo sinonimo = null;
		try {
			sinonimo = sinonimiDao.get(cercata);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	
		
		if (sinonimo == null) {
			
			sinonimo = creaNuovoSinonimo(cercata);
			sinonimiDao.save(sinonimo);
						
		}else {
			
			sinonimo.increment();
			sinonimiDao.update(sinonimo);
		}
		return sinonimo.getPaese();
			
	}
	
	
	public Match applicaAlgoritmi(String cercata) {
		ApplicationContext context =  new ClassPathXmlApplicationContext(beans_stringhe);
		SimilarString similarString = (SimilarString) context.getBean("checkString");
		return similarString.getMostSimilar(cercata, standard.getParoleStd());
	}
	
	private Sinonimo creaNuovoSinonimo(String cercata) throws PaeseNotFoundException {
		Match matchStandard = applicaAlgoritmi(cercata);
		
		if(matchStandard == null ) throw new PaeseNotFoundException(cercata);
			
		
		Paese paese = new PaeseDAOImpl().getByNome(matchStandard.getMatch());
		
		Sinonimo sinonimo = new Sinonimo();
		
		sinonimo.setCercata(cercata);
		sinonimo.setPaese(paese);
		sinonimo.setAlgoritmo(matchStandard.getAlgorithm());
		sinonimo.increment();
		
		return sinonimo;
	}
}
