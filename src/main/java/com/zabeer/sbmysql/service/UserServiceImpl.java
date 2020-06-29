package com.zabeer.sbmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabeer.sbmysql.entity.Users;
import com.zabeer.sbmysql.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository UserRepository;

	@Override
	public Users getUserById(Integer id) {
		Optional<Users> users = UserRepository.findById(id);
		return users.isPresent() ? users.get() : null;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
