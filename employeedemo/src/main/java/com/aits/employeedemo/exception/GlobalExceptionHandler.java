package com.aits.employeedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aits.employeedemo.entity.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFound e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HikeIsMore.class)
	public ResponseEntity<String> handleHikeIsMore(HikeIsMore h)
	{
		return new ResponseEntity<String>(h.getMessage(),HttpStatus.NOT_FOUND);
	}

}
