package com.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.entity.UserInfo;
import com.taskmanagement.repository.UserRepositoy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserServiceImpl implements CustomUserService{
	
	@Autowired
	private UserRepositoy userRepositoy;
	
	@Override
	public UserInfo addUser(UserInfo userInfo) {
		System.out.println("adding user : "+ userInfo);
		return userRepositoy.save(userInfo);
	}
	
	
	@Override
	public UserInfo findByUsername(String email) {
		return userRepositoy.findByEmail(email);
	}

}
