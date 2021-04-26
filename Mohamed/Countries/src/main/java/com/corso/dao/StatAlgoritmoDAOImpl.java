package com.corso.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import com.corso.paesi.StatAlgoritmo;

public class StatAlgoritmoDAOImpl extends DAO implements StatAlgoritmoDAO {


	@Override
	public Class getStringClass() {
		return StatAlgoritmo.class;
	}

	public List<StatAlgoritmo> getStatsAlgoritmi() {
		return getAll();
	}

}
