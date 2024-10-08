package com.taskmanagement.service;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taskmanagement.dao.UserLoginRepository;
import com.taskmanagement.entity.UserInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
    public UserDetailsServiceImpl() {}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userLoginRepository.findByUserLoginName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found with email id: " + username);
        }

        //return the Spring Security UserDetails object
        return org.springframework.security.core.userdetails.User.builder()
                .username(userInfo.getEmail())     
                .password(userInfo.getPassword())
                .authorities(userInfo.getAuthorities().stream()
                		.map(SimpleGrantedAuthority::new)
                		.collect(Collectors.toList()))//Replace with appropriate roles from userDetails if available
                .build();
    }
}