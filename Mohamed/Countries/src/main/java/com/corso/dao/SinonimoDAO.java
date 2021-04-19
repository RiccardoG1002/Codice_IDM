package com.corso.dao;

import com.corso.paesi.Sinonimo;

public interface SinonimoDAO {
	
	Sinonimo get(String cercata);
	void update();
	void save(Sinonimo sinonimo);
	
}
