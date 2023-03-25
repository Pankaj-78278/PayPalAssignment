package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetailException> myRouteException(UserException re, WebRequest webReq){
		
		ErrorDetailException red = new ErrorDetailException();
		red.setTimestamp(LocalDateTime.now());
		red.setMessage(re.getMessage());
		red.setDetail(webReq.getDescription(false));
		
		return new ResponseEntity<ErrorDetailException>(red, HttpStatus.BAD_REQUEST);
		
	}

	
}
