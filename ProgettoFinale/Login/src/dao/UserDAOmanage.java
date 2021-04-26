package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.User;


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

	   
}
