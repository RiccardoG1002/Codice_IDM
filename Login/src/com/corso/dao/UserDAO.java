package com.corso.dao;

import com.corso.dto.User;

public interface UserDAO {
	public String addUser(User user);
	public boolean isEmpty();
	public boolean ifExistUsername(User user);
	public boolean ifExistPassword(User user);
	public boolean ifExistUser(User user);
	public int setNewPassword(String username, String password);
}
