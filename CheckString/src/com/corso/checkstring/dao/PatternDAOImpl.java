package com.corso.checkstring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;

public class PatternDAOImpl extends BaseDAO<Pattern> implements PatternDAO {
	
	final static int PAGE_SIZE = 6;
	
	@Override
	public Pattern get(Id id) {
		
		return (Pattern) super.getBeanDTO(Pattern.class, id);
	}

	
	@Override
	public int setApprove(String userPattern, int approve) {
		Session session =super.getFactory().openSession();
	    Transaction tx = null;
	    int res=0;
	    try {
	    	tx = session.beginTransaction();
	    	Query<Pattern> query=session.createQuery("UPDATE Pattern set approved=:approved WHERE user_pattern=:search");
	    	query.setParameter("approved", approve);
	    	query.setParameter("search", userPattern);
	    	res=query.executeUpdate();
	    	tx.commit();
	    } catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    } finally {
	         session.close(); 
	      }
	    return res;
	}

	@Override
	public List<Pattern> getPatternsToBeApproved(int page) {
		
		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patternList = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Pattern WHERE approved=0";
			Query<Pattern> q = session.createQuery(hql);
			
			// for paging 
			q.setFirstResult(page*PAGE_SIZE);
			q.setMaxResults(PAGE_SIZE);
			
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
	public String getAlgorithmSuccess(String algorithm) {
		
		Session session = getFactory().openSession();
		Transaction tx = null;
		String count = "0";
		
		try {
			tx = session.beginTransaction();
			
			String hql = "SELECT count(*) FROM Pattern WHERE approved=1 AND algorithm=:algorithm";
			Query<Pattern> q = session.createQuery(hql);
			q.setParameter("algorithm", algorithm);
			
			count = q.getSingleResult().toString();
			
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
		
		return count;
	}

	@Override
	public int deletePattern(String userPattern) {
		Session session = getFactory().openSession();
		Transaction tx = null;
		String count = "0";
		
		int res=0;
		try {
			tx = session.beginTransaction();
			
			String hql = "DELETE from Pattern WHERE userPattern=:userPattern";
			Query<Pattern> q = session.createQuery(hql);
			q.setParameter("userPattern", userPattern);
			
			res=q.executeUpdate();
			
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
		
		return res;
	}

	@Override
	public int updateCountry(String userPattern, String newCountry) {
		Session session = getFactory().openSession();
		Transaction tx = null;
		String count = "0";
		
		CountryDAO cDao = new CountryDAOImpl();
		
		int res=0;
		try {
			tx = session.beginTransaction();
			
			String hql = "UPDATE Pattern set country=:country, algorithm=:algorithm WHERE userPattern=:userPattern";
			Query<Pattern> q = session.createQuery(hql);
			q.setParameter("userPattern", userPattern);
			q.setParameter("algorithm", "admin");
			
			System.out.println("DAO = "+userPattern + "   "+newCountry);
			Country country = cDao.getCountryByName(newCountry);
			q.setParameter("country", country);
			
			System.out.println(country);
			res=q.executeUpdate();
			
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
		
		return res;
	}

	@Override
	public Pattern getPatternByName(String name) {

		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patternList = null;
		
		Pattern p=null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Pattern WHERE userPattern=:userPattern";
			Query<Pattern> q = session.createQuery(hql);
			q.setParameter("userPattern", name);
			p = q.getSingleResult();
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
		
		return p;
	}
}
