package com.taskmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.entity.UserInfo;

@Repository
public interface UserRepositoy extends MongoRepository<UserInfo, String>{
	UserInfo findByEmail(String email);
}
