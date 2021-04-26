package test;

import dao.UserDAO;

import dao.UserDAOmanage;
import dto.User;

public class TestDB {
	
	public static void main(String[] args) {
		
		User admin = new User("admin", "admin", "admin");
		User user = new User("matteo", "admin", "admin");
		
		UserDAO uDAO = new UserDAOmanage();
		
		if(uDAO.isEmpty()){
			uDAO.addUser(admin);
		}
		
		if(!uDAO.ifExistUsername(user)) {
			if(uDAO.ifExistUser(user)) {
				System.out.println("� gi� presente");
			} else {
				System.out.println("non � presente");
				uDAO.addUser(user);
				System.out.println("aggiunto nuovo user");
			}
		}
			

	}
}
