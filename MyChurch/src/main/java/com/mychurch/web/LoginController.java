package com.mychurch.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mychurch.domain.User;
import com.mychurch.repositories.UserRepository;
import com.mychurch.security.Authority;
import com.mychurch.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login() {
			return "login";
		}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user",new User());
		
		Authority authority= new Authority();
		model.put("authority", authority);
		
	//	authorities.get(0).getAuthority();
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(User user,Authority authority) {
		Set<Authority> authorities = new HashSet<>();
		Authority authority1= new Authority();
		Authority authority2 = new Authority();
		String role = authority.getAuthority();
		if(role.equals("ROLE_USER")) {
			System.out.println(role);
			authority2.setAuthority("ROLE_USER");
			authorities.add(authority2);
		}
		else {
			authority1.setAuthority("ROLE_ADMIN");
			authorities.add(authority1);
			authority2.setAuthority("ROLE_USER");
			authorities.add(authority2);
			
		}
					
		userService.save(user,authorities);
		return "redirect:/register";
	}
	

}
