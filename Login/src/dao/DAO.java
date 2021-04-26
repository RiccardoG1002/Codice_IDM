package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import dto.DTO;
import dto.User;

public abstract class DAO {
private SessionFactory factory; 
	
	protected DAO() {
		try {
			this.factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable ex) { 
	    	System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	protected final SessionFactory getFactory() {
		return this.factory;
	}
	
	
	protected String addDTO(DTO dto){
		Session session = this.factory.openSession();
		Transaction tx = null;
		String userID = null;
		try {
			tx = session.beginTransaction();
			userID = (String) session.save(dto); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return userID;
	}
	
	
	
	/* Method to check if the table is empty*/
	protected boolean isEmpty(Class clazz){
		Session session = factory.openSession();
		Transaction tx = null;
		List list = null;
      
		try {
			tx = session.beginTransaction();
			String hql = "FROM " + clazz.getSimpleName();
			list = session.createQuery(hql).list(); 
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return list.isEmpty();
	}
	
	
	
	/* Method to check if record exits*/
	protected boolean isDTOoneElement(DTO dto, String field, String input){
		Session session = factory.openSession();
		Transaction tx = null;
		User userTemp = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM " + dto.getClass().getSimpleName() + " WHERE " + field + "='" + input + "'"; 
			
			Query q = session.createQuery(hql);

			if(q.list().size() != 0) {
				userTemp = (User) q.getSingleResult();
			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		if(userTemp == null) { return false; }
		else { return true; }
	}
	
	
	// controllo su due elementi
	protected boolean isDTOtwoElements(DTO dto, 
										String field1, 
										  String field2, 
										    String input1, 
										      String input2){
		Session session = factory.openSession();
		Transaction tx = null;
		User userTemp = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM " + dto.getClass().getSimpleName() + 
							" WHERE " + field1 + "='" + input1 + "'" + " and " + 
										field2 + "='" + input2 + "'"; 
			Query q = session.createQuery(hql);

			if(q.list().size() != 0) {
				userTemp = (User) q.getSingleResult();
			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		if(userTemp == null) { return false; }
		else { return true; }
	}
	
	
}
