package com.corso.dizionario;

import java.util.ArrayList;
import java.util.Collection;

import com.corso.dao.PaeseDAO;
import com.corso.dao.PaeseDAOImpl;
import com.corso.paesi.Paese;

public class DizionarioDaDb implements Dizionario{

	public Collection<String> getParoleStd() {
		PaeseDAO dao = new PaeseDAOImpl();
		return dao.getNomiPaesi();
	}

	
}
