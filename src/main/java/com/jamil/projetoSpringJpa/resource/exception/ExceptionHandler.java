package com.jamil.projetoSpringJpa.resource.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.jamil.projetoSpringJpa.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e, HttpServletRequest request)
	{
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(),
												e.getMessage(),
												System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
