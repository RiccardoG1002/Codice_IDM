package com.corso.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.query.Query;

import com.corso.paesi.Paese;
import com.corso.paesi.Sinonimo;

public class SinonimoDAOImpl extends DAO<Sinonimo> implements SinonimoDAO{

	@Override
	public Class getStringClass() {
		return Sinonimo.class;
	}

	public Collection<Sinonimo> getSinonimiDaApprovare() {
		openCurrentSessionwithTransaction();
		
		String hql = "From Sinonimo Where approvato=:approvato1";
		Query q = getCurrentSession().createQuery(hql);
		q.setParameter("approvato1", 0);
		List<Sinonimo> tList =  q.getResultList();

		closeCurrentSessionWithTransaction();
		
		return tList;
	}


	

}
