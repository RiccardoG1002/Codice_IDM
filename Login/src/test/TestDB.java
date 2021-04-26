package test;

import com.corso.dao.UserDAO;
import com.corso.dao.UserDAOmanage;
import com.corso.dto.User;

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
				System.out.println("è già presente");
			} else {
				System.out.println("non è presente");
				uDAO.addUser(user);
				System.out.println("aggiunto nuovo user");
			}
		}
			

	}
}
