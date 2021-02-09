package com.mychurch;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.mychurch.web.dto.PasswordResetDto;

class FieldMatchConstraintValidatorTest {

	private static Validator validator;

	@BeforeTestClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testValidPasswords() {

		PasswordResetDto passwordReset = new PasswordResetDto();
		passwordReset.setPassword("password");
		passwordReset.setConfirmPassword("password");
		Set<ConstraintViolation<PasswordResetDto>> constraintViolations = validator.validate(passwordReset);
		assertEquals(constraintViolations.size(),0);
		
		System.out.println(constraintViolations.size());
		
	}
	
	@Test
	public void testInvalidPassword() {
		PasswordResetDto passwordReset = new PasswordResetDto();
		passwordReset.setPassword("password");
		passwordReset.setConfirmPassword("invalid-password");
		Set<ConstraintViolation<PasswordResetDto>> constraintViolations = validator.validate(passwordReset);
		System.out.println(constraintViolations.size());
		assertEquals(constraintViolations.size(), 1);
		
	}

}
