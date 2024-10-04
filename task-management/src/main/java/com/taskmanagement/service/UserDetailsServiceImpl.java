//package com.taskmanagement.service;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.taskmanagement.dao.UserLoginRepository;
//import com.taskmanagement.pojo.UserLogin;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    //private final UserRepository userRepository;
//    //private final UserLoginRepository userLoginRepository;
//
//	@Autowired
//	private UserLoginRepository userLoginRepository;
//	
//    public UserDetailsServiceImpl() {}
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserLogin userLogin = userLoginRepository.findByUserLoginName(username);
//        if (userLogin == null) {
//            throw new UsernameNotFoundException("User not found with email id: " + username);
//        }
//
//        //return the Spring Security UserDetails object
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(userLogin.getUsername())     
//                .password(userLogin.getPassword())
//                .authorities(Collections.emptyList())//Replace with appropriate roles from userDetails if available
//                .build();
//    }
//}