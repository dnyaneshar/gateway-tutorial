package com.taskmanagement.dao;

import com.taskmanagement.pojo.UserLogin;

public interface UserLoginRepository {
	public UserLogin findByUserLoginName(String username);
}
