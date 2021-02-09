package com.mychurch;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	
	@Test
	public void generate_encrypted_password() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "asdf";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);
		assertThat(rawPassword,not( encodedPassword));
	}

}
