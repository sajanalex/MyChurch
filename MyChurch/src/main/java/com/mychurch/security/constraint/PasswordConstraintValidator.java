package com.mychurch.security.constraint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.message.callback.PasswordValidationCallback;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.type.CharacterType;
import org.hibernate.validator.internal.constraintvalidators.hv.LengthValidator;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.beans.BeanUtils;

import com.jayway.jsonpath.internal.function.text.Length;


public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

	
	@Override
	public void initialize(ValidPassword constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

	PasswordValidator validator = new PasswordValidator(new LengthRule(8, 30),
			new CharacterRule(EnglishCharacterData.UpperCase,1),
			new CharacterRule(EnglishCharacterData.LowerCase, 1),
			new CharacterRule(EnglishCharacterData.Digit, 1),
			new CharacterRule(EnglishCharacterData.Special, 1),
			new WhitespaceRule());
	RuleResult result = validator.validate(new PasswordData(password));
	if(result.isValid()) {
		return true;
	}
	List<String> messages = validator.getMessages(result);
	String messageTemplate = messages.stream().collect(Collectors.joining(","));
	context.buildConstraintViolationWithTemplate(messageTemplate)
	.addConstraintViolation()
	.disableDefaultConstraintViolation();

		return false;
	}

//	private String firstFieldName;
//	private String secondFieldName;
//	private String message;
//	
//	@Override
//	public void initialize(FieldMatch constraintAnnotation) {
//		firstFieldName = constraintAnnotation.first();
//		secondFieldName= constraintAnnotation.second();
//		message= constraintAnnotation.message();
//	}
//	
//	
//	@Override
//	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
//		boolean valid = true;
//		final Object firstObj = BeanUtils.getPropertyDescriptor(value.getClass(), firstFieldName);
//		final Object secondObj = BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName);
//		valid = (firstObj==null && secondObj==null) || firstObj != null &&  firstObj.equals(secondObj);
//		if(valid) {
//			return valid;
//
//		}
//		else {
//			context.buildConstraintViolationWithTemplate(message)
//			.addPropertyNode(firstFieldName)
//			.addConstraintViolation()
//			.disableDefaultConstraintViolation();
//		return valid;
//		}
//	}



}
