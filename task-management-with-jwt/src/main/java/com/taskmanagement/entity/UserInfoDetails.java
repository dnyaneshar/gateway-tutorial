package com.taskmanagement.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDetails implements UserDetails {


	private static final long serialVersionUID = 1L;

	private String username;

    private String password;
    
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(UserInfo userInfo) {
    	this.username = userInfo.getEmail();
    	this.password = userInfo.getPassword();
    	
		this.authorities = userInfo.getAuthorities().stream().map(
		SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getPassword() {
		return this.password;
	}
	
	
}