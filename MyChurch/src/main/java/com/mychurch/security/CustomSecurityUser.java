package com.mychurch.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mychurch.domain.User;


public class CustomSecurityUser extends User implements UserDetails {
	
	

	public CustomSecurityUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getPassword());
	}
	
	@Override
	public Set<Authority> getAuthorities(){
		return super.getAuthorities();
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
