package com.dsbootcamp.CrudClientes.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsbootcamp.CrudClientes.services.exceptions.DatabaseException;
import com.dsbootcamp.CrudClientes.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){		
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		error.setTimestamp(Instant.now());
		error.setError("Resource not found");
		error.setStatus(status.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest request){		
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		error.setTimestamp(Instant.now());
		error.setError("Database exception");
		error.setStatus(status.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
