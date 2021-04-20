package com.corso.dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.corso.exceptions.NotFoundException;

public abstract class DAO<T> {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction currentTransaction;
	
	DAO(){
		try {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	      
		}catch (Throwable ex) { 
	    
	    	 System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}	
	
		
    protected void openCurrentSession() {
        session = sessionFactory.openSession();
    }
 
    protected void openCurrentSessionwithTransaction() {
        session = sessionFactory.openSession();
        currentTransaction = session.beginTransaction();
    }
     
    protected void closeCurrentSession() {
        session.close();
    }
     
    protected void closeCurrentSessionWithTransaction() {
    	// TODO: try and catch 
        currentTransaction.commit();
        session.close();
    }
      
    protected Session getCurrentSession() {
        return session;
    }
 
    protected Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    
    
    public abstract Class<?> getStringClass();
    
	public T get(String key) throws NotFoundException {
		openCurrentSessionwithTransaction();
		
		T t = (T) session.get(getStringClass(), key);

		if(t == null) throw new NotFoundException(getStringClass().getSimpleName(),key);
		
    	closeCurrentSessionWithTransaction();
    	return t;
	}
	
	
	
	
	public List<T> getAll(){
		openCurrentSessionwithTransaction();
		
		String hql = "From "+ getStringClass().getSimpleName();
		Query q = session.createQuery(hql);
	    List<T> tList =  q.getResultList();

		closeCurrentSessionWithTransaction();
		return tList;
	}
    
    public void save(T t) {
    	openCurrentSessionwithTransaction();
    	session.save(t);
    	closeCurrentSessionWithTransaction();
	}
    
    public void update(T t) {
    	openCurrentSessionwithTransaction();
    	session.update(t);
    	closeCurrentSessionWithTransaction();
	}
    
    public void delete(T t) {
    	openCurrentSessionwithTransaction();
    	session.delete(t);
    	closeCurrentSessionWithTransaction();
	}
}
