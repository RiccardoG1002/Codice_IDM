package com.corso.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.corso.paesi.Paese;

public class PaeseDAOImpl extends DAO<Paese> implements PaeseDAO{

	@Override
	public Class<?> getStringClass() {
		return Paese.class;
	}

	@Override
	public void delete(Paese t) {
		super.delete(t);
	}


	public Collection<String> getNomiPaesi() {
		openCurrentSessionwithTransaction();
		
		String sql = "Select name from standard";
		Query query = getCurrentSession().createSQLQuery(sql);
		
	    ArrayList<String> nomi =  (ArrayList<String>) query.getResultList();
		
		closeCurrentSessionWithTransaction();
		
		
		return nomi;
		
	}
	
	
	
	
	
	
}
