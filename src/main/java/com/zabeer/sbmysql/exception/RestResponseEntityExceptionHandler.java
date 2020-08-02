package com.zabeer.sbmysql.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value 
      = { PreconditionsFailedException.class})
    protected ResponseEntity<Object> handlePreconditionFailed(
      Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
    }
    
    @ExceptionHandler(value 
    	      = { ResourceNotFoundException.class})
    	    protected ResponseEntity<Object> handleResourceNotFound(
    	      Exception ex, WebRequest request) {
    	        String bodyOfResponse = ex.getMessage();
    	        return handleExceptionInternal(ex, bodyOfResponse, 
    	          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    	    }
    
    
}