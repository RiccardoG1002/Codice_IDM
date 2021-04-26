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
	public List<Pattern> getPatternsFromCountryID(Id id) {

		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patternList = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Pattern WHERE country=:id";
			Query q = session.createQuery(hql);
			q.setParameter("id", id);
			
			patternList = (List<Pattern>) q.list();
			
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
		
		return patternList;
	}
	

	@Override
	public Country getCountry(String code) {
		
		return (Country) super.getBeanDTO(Country.class, new Id(code));
	}
}