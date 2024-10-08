package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.entity.UserInfo;
import com.taskmanagement.service.CustomUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private CustomUserService customUserService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserInfo> signup(@RequestBody UserInfo user){
		System.out.println("adding user to the database");
		
		UserInfo userAdded =  customUserService.addUser(user);
		
		return ResponseEntity.ok(userAdded);
		
	}

}
