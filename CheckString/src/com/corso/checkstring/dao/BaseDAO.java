package com.corso.checkstring.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.corso.checkstring.beans.BeanDTO;
import com.corso.checkstring.beans.Id;



public abstract class BaseDAO<T extends BeanDTO> {
	
	private SessionFactory factory;
	
	protected BaseDAO() {
		
		try {
			this.factory = new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable e) {
			System.err.println("Impossibile creare la SessionFactory" + e);
        //			throw new ExceptionInInitializerError(e);
		}
	}
	
	protected final SessionFactory getFactory() {
		
		return this.factory;
	}
	
	public final String save(T dto) {
		
		Session session = this.factory.openSession();
		Transaction tx = null;
		String BeanID = null;
		
		try {
			tx = session.beginTransaction();
			BeanID = (String) session.save(dto);
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
		
		return BeanID;
	}
	
	protected final BeanDTO getBeanDTO(Class clazz, Id id) {
		
		Session session = this.factory.openSession();
		Transaction tx = null;
		BeanDTO dto = null;
		
		try {
			tx = session.beginTransaction();
			dto = (BeanDTO) session.get(clazz, id.getId());
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
		
		return dto;
	}
	
	protected final BeanDTO getBeanDTOByName(Class clazz, String field, Serializable name) {

		Session session = getFactory().openSession();
		Transaction tx = null;
		BeanDTO dto = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "FROM " + clazz.getSimpleName() + " WHERE " + field + "=:name";
			Query q = session.createQuery(hql);
			q.setParameter("name", name);
			
			dto = (BeanDTO) q.getSingleResult();
			
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
		
		return dto;
	}
	
	protected final ArrayList<String> getColumn(Class clazz, String field) {

		Session session = getFactory().openSession();
		Transaction tx = null;
		ArrayList<String> column = null;
		
		try {
			tx = session.beginTransaction();
			
			String hql = "SELECT " + field + " FROM " + clazz.getSimpleName();
			column = (ArrayList<String>) session.createQuery(hql).list();
			
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
		
		return column;
	}
	

	
}
