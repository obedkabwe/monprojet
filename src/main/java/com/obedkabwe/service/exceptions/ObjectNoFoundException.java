package com.obedkabwe.service.exceptions;

public class ObjectNoFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	
	public ObjectNoFoundException (String msg) {
		super(msg);
	}
	
	


	public ObjectNoFoundException (String msg, Throwable cause) {
		super(msg,cause);
	}
	
	
}
