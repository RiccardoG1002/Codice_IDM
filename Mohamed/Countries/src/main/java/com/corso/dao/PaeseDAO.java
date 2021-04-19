package com.corso.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.corso.paesi.Paese;

public interface PaeseDAO {
	
	Paese get(String codice);
	void update(Paese p);
	void save(Paese p);
	Collection<String> getNomiPaesi();
	List<Paese> getAll();
	
	
}
