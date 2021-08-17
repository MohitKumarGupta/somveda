package com.somveda.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.somveda.model.ErrorMessage;

@RestControllerAdvice
public class SomvedaControllerAdvice {
	
	@Autowired
	Environment env;
	
	@ExceptionHandler(SomvedaException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(SomvedaException s){
		ErrorMessage error = new ErrorMessage(env.getProperty(s.getMessage()));
		if(error.getMessage()==null) {
			error.setMessage(s.getMessage());
		}
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception s){
		ErrorMessage error = new ErrorMessage(s.getMessage());
		return ResponseEntity.ok(error);
	}
}
