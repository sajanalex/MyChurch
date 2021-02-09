package com.mychurch.security.constraint;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

@Target({ElementType.FIELD,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {
	
	String message() default "The fields must match";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
//	String first();
//	String second();
	
//	@Target({ElementType.FIELD,ANNOTATION_TYPE})
//	@Retention(RetentionPolicy.RUNTIME)
//	@Documented
//	@interface List{
//		FieldMatch[] value();
//	}

}
