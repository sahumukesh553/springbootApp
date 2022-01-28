package com.mukeshsoft.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mukeshsoft.exception.AddressNotFoundException;
import com.mukeshsoft.exception.NoDataFoundException;
import com.mukeshsoft.exception.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex,WebRequest req)
	{
		Map<String ,Object> body=new LinkedHashMap<>();
		body.put("timesTamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		body.put("request", req.getContextPath());
		return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req)
	{
		Map<String ,Object> body=new LinkedHashMap<>();
		body.put("timesTamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<Object> handleAddressNotFoundException(AddressNotFoundException ex,WebRequest req)
	{
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("timesTamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,Object> body=new LinkedHashMap<>();
		body.put("timesTamp", LocalDateTime.now());
		body.put("status", status.value());
		List<String> errors=ex.getBindingResult().getFieldErrors().stream()
				.map(x->x.getDefaultMessage()).collect(Collectors.toList());
		body.put("ERRORS", errors);
		
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST);
	}
	

}
