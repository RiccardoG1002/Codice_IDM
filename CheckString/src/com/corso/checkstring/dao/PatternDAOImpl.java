package com.corso.checkstring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;

public class PatternDAOImpl extends BaseDAO<Pattern> implements PatternDAO {

	@Override
	public Pattern get(Id id) {
		
		return (Pattern) super.getBeanDTO(Pattern.class, id);
	}

	@Override
	public Pattern[] getPendingPatterns() {
		
		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patternList = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Pattern WHERE approved=0";
			Query q = session.createQuery(hql);
			
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
		
		Pattern[] p = new Pattern[patternList.size()];
		
		return patternList.toArray(p);
	}
	
	@Override
	public int setApprove(String userPattern, int approve) {
		Session session =super.getFactory().openSession();
	    Transaction tx = null;
	    int res=0;
	    try {
	    	tx = session.beginTransaction();
	    	Query query=session.createQuery("UPDATE Pattern set approved=:approved WHERE user_pattern=:search");
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
	public List<Pattern> getPatternsToBeApproved() {
		
		Session session = getFactory().openSession();
		Transaction tx = null;
		List<Pattern> patternList = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM Pattern WHERE approved=0";
			Query q = session.createQuery(hql);
			
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
			Query q = session.createQuery(hql);
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
}
