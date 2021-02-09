package com.mychurch.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.server.ExposesResourceFor;

import com.mychurch.security.constraint.ValidPassword;

//@FieldMatch(first = "password", second = "confirmPassword", message = "password fields must match")
public class PasswordResetDto {
	
	@NotEmpty
	@ValidPassword
	private String password;
	@NotEmpty
	private String confirmPassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

}
