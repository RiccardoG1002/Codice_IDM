package com.corso.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;
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



	public Collection<String> getNomiPaesi() {
		openCurrentSessionwithTransaction();
		
		String sql = "Select nome from standard";
		Query query = getCurrentSession().createSQLQuery(sql);
		
	    ArrayList<String> nomi =  (ArrayList<String>) query.getResultList();
		
		closeCurrentSessionWithTransaction();
		
		
		return nomi;
		
	}
	
	
	public Paese getByNome(String nome) {
		
		openCurrentSessionwithTransaction();
		
		String hql = "from Paese where nome=:nome";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("nome", nome);
		
		Paese paese =  (Paese) query.uniqueResult();
		
		closeCurrentSessionWithTransaction();
		
		return paese;
	}
	
	
	
	
	
	
}
