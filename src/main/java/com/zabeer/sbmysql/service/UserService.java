package com.zabeer.sbmysql.service;

import java.util.List;

import com.zabeer.sbmysql.entity.Users;

public interface UserService {
	
	
	public Users getUserById(Integer id);
	public List<Users> getAllUsers();
	public void deleteUser(Integer id);
	public Users addUser(Users user);
	public Users updateUser(Users user);

}
