package com.zabeer.sbmysql.exception;

public class PreconditionsFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PreconditionsFailedException(String message) {
		super(message);
	}
	
	public PreconditionsFailedException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	

}
