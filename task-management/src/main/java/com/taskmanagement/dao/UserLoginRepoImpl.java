package com.taskmanagement.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.taskmanagement.pojo.UserLogin;

@Service
public class UserLoginRepoImpl implements UserLoginRepository{
	
	static Map<String, UserLogin> users = new HashMap<>();
	
	static {
		UserLogin user1= new UserLogin("admin", "admin");
		users.put("admin", user1);
		
		UserLogin user2= new UserLogin("user", "user");
		users.put("user", user2);
	}
	
	@Override
	public UserLogin findByUserLoginName(String username) {
		return users.get(username);
	}

}
