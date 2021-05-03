package com.corso.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.dto.User;


public class UserDAOmanage extends DAO implements UserDAO{
	//private static SessionFactory factory; 
	 
	public UserDAOmanage() {
		super();
	}
	 
	
	@Override
	public String addUser(User user){
		return super.addDTO(user);
	}
	
	@Override
	public boolean isEmpty(){
		return super.isEmpty(User.class);
	}


	@Override
	public boolean ifExistUsername(User user) {	
		return isDTOoneElement(user, "username", user.getUsername());
	}


	@Override
	public boolean ifExistPassword(User user) {
		return isDTOoneElement(user, "password", user.getPassword());
	}
	
	
	@Override
	public boolean ifExistUser(User user) {
		return isDTOtwoElements(user, "username", "password", user.getUsername(), user.getPassword());
	}


	@Override
	public int setNewPassword(String username, String password) {
		Session session = super.getFactory().openSession();
		Transaction tx = null;
		User userTemp = null;
		
		int res=0;
		try {
			tx = session.beginTransaction();
			Query q=session.createQuery("UPDATE User SET  password=:password WHERE username=:username");
			q.setParameter("password",password);
			q.setParameter("username",username);
			res = q.executeUpdate();
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return res;
	}

	   
}
