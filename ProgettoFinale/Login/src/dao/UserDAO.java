package dao;

import dto.User;

public interface UserDAO {
	public String addUser(User user);
	public boolean isEmpty();
	public boolean ifExistUsername(User user);
	public boolean ifExistPassword(User user);
	public boolean ifExistUser(User user);
	
}
