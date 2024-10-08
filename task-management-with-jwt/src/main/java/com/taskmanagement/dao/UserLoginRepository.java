package com.taskmanagement.dao;

import com.taskmanagement.entity.UserInfo;

public interface UserLoginRepository {
	public UserInfo findByUserLoginName(String username);
}
