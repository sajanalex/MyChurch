package com.mychurch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mychurch.domain.User;
import com.mychurch.repositories.UserRepository;
import com.mychurch.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepo.findByUsername(username);
		if(user==null) throw new UsernameNotFoundException("invalid username/password");
		return new CustomSecurityUser(user);
		
	}

}
