package com.taskmanagement.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.taskmanagement.entity.UserInfo;
import com.taskmanagement.pojo.UserLogin;

@Service
public class UserLoginRepoImpl {
	
	static List<UserInfo> users = new ArrayList<>();
	
	static {
		UserInfo user1 = new UserInfo();
		user1.setAuthorities( List.of("ROLE_USER"));
		user1.setEmail("user@gmail.com");
		user1.setFirstName("Raju");
		user1.setLastName("narwade");
		user1.setPassword("user");
		
		UserInfo user2 = new UserInfo();
		user2.setAuthorities( List.of("ROLE_ADMIN"));
		user2.setEmail("admin@gmail.com");
		user2.setFirstName("Adi");
		user2.setLastName("Narwade");
		user2.setPassword("admin");
		
		users.add(user1); // add user to the list
		users.add(user2);
	}
	
	//find user by username (email)
	//@Override
	public UserInfo findByUserLoginName(String username) {
		return users.stream().filter(user -> user.getEmail()
				.equals(username)).findFirst().get();
	}

}
