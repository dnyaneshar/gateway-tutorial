package com.taskmanagement.service;

import com.taskmanagement.entity.UserInfo;

public interface CustomUserService {
	UserInfo addUser(UserInfo userInfo);
	UserInfo findByUsername(String email);
}
