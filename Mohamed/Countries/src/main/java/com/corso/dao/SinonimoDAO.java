package com.corso.dao;

import com.corso.exceptions.NotFoundException;
import com.corso.paesi.Sinonimo;

public interface SinonimoDAO {
	
	Sinonimo get(String cercata) throws NotFoundException;
	void update(Sinonimo sinonimo);
	void save(Sinonimo sinonimo);
	
}
