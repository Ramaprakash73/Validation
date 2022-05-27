package com.slokam.rama.exceptiohandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Rama_ExceptionHandler {
	Logger logger = LoggerFactory.getLogger(Rama_ExceptionHandler.class);
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(ConstraintViolationException.class) public List<String>
	 * handleException(ConstraintViolationException cVE){
	 * 
	 * List<String> errorList = new ArrayList<String>(); Set<ConstraintViolation<?>>
	 * error = cVE.getConstraintViolations(); for (ConstraintViolation<?>
	 * constraintViolation : error) { logger.info("Error  ======  " +
	 * constraintViolation.getMessage());
	 * errorList.add(constraintViolation.getMessage()); }
	 * 
	 * return errorList; }
	 */
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException1(MethodArgumentNotValidException cVE){
		
		Map<String, String> errorMap = new HashMap<String, String>();
		List<FieldError> errorList = cVE.getBindingResult().getFieldErrors();
		for (FieldError fieldError : errorList) {
			logger.info("error Details are ===  " + fieldError.getField() + ":  " + fieldError.getDefaultMessage());
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return errorMap;
	}


}
