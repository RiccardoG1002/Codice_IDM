package com.corso.checkstring.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.checkstring.beans.StatAlgoritmo;

public class StatAlgoritmoDAOImpl extends BaseDAO<StatAlgoritmo> implements StatAlgoritmoDAO {


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<StatAlgoritmo> getStatsAlgoritmi() {
		Session session = getFactory().openSession();
		Transaction tx = null;
		List<StatAlgoritmo> algoritmi = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "From "+ StatAlgoritmo.class.getSimpleName() + " where algoritmo is not null";
			Query q = session.createQuery(hql);
		    algoritmi =  q.getResultList();
			
			tx.commit();
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return algoritmi;
	}

}
