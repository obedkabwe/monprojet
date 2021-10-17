package com.obedkabwe.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.obedkabwe.service.exceptions.DataIntegrityException;
import com.obedkabwe.service.exceptions.ObjectNoFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
 
	@ExceptionHandler(ObjectNoFoundException.class)
	public ResponseEntity<StandarError> objNotFound(ObjectNoFoundException e, HttpServletRequest request){
		
		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandarError> objNotFound(DataIntegrityException e, HttpServletRequest request){
		
		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	
	
}
