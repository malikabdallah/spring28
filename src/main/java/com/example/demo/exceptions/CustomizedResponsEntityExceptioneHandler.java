package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
@RestController
public class CustomizedResponsEntityExceptioneHandler extends ResponseEntityExceptionHandler {

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest web){
		
		
		ExceptionResponse resp=new ExceptionResponse(new Date(),ex.getMessage(),web.getDescription(false));
		

		return new ResponseEntity(resp,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(Exception ex, WebRequest web){
		
		
		ExceptionResponse resp=new ExceptionResponse(new Date(),ex.getMessage(),web.getDescription(false));
		

		return new ResponseEntity(resp,HttpStatus.NOT_FOUND);
	
	}
	
	
}
