package com.corso.checkstring.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.beans.StatAlgoritmo;

public class CountryDAOImpl extends BaseDAO<Country> implements CountryDAO {

	@Override
	public ArrayList<String> getColumnFromTable(String field) {

		return super.getColumn(Country.class, field);
	}

	@Override
	public boolean isEmpty() {
		
		return getColumnFromTable("name").isEmpty() ? true : false;
	}

	@Override
	public Country getCountryByName(Serializable name) {
		
		return (Country) super.getBeanDTOByName(Country.class, "name", name);
	}

	@Override
	public List<Pattern> getPatternsFromCountryID(Country id) {
		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patterns = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "From "+ Pattern.class.getSimpleName() + " where country=:id";
			Query q = session.createQuery(hql);
			q.setParameter("id", id);
		    patterns =  q.getResultList();
			
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
		
		return patterns;
	}

	

	@Override
	public Country getCountry(String code) {
		
		return (Country) super.getBeanDTO(Country.class, new Id(code));
	}

	@Override
	public List<Country> getCountries() {

		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Country> countryList = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Country ORDER BY name asc";
			Query q = session.createQuery(hql);
			q.setCacheable(true);
			
			countryList = (List<Country>) q.list();
			
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
		
		return countryList;
	}
}
