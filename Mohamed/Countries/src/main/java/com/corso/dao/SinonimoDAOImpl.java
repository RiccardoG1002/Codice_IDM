package com.corso.dao;

import com.corso.paesi.Sinonimo;

public class SinonimoDAOImpl extends DAO<Sinonimo> implements SinonimoDAO{

	@Override
	public Class getStringClass() {
		return Sinonimo.class;
	}


	

}
