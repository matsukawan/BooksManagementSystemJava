package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.annotation.Registered;
import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

public class RegisteredValidator implements ConstraintValidator<Registered,String>{
	
	@Autowired
	private BooksService service;
	
	public void initialize(Registered constraintAnnotation) {
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Books isbn = service.findByIsbn(value).orElse(null);
		if(isbn == null) {
			return true;
		}
		
		return false;
		
	}
	
}
