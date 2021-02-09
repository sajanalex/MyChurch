package com.mychurch.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mychurch.domain.User;
import com.mychurch.repositories.UserRepository;
import com.mychurch.security.Authority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user,Set<Authority> authorities) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		authorities.forEach((Authority a)->{Authority authority = new Authority();
		authority.setUser(user);
		authority.setAuthority(a.getAuthority());
		user.getAuthorities().add(authority);
		userRepo.save(user);});
	
		return user;
	}

}
