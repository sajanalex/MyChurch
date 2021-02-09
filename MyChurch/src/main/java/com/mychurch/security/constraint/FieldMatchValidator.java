package com.mychurch.security.constraint;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mychurch.web.dto.PasswordResetDto;
@Service
public class FieldMatchValidator implements Validator  {

	@Override
	public boolean supports(Class<?> paramClass) {
		return PasswordResetDto.class.equals(paramClass);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {

		PasswordResetDto password = new PasswordResetDto();
		if(!password.getPassword().equals(password.getConfirmPassword())) {
			errors.reject(null);
			
		}
		
	}

	

}
