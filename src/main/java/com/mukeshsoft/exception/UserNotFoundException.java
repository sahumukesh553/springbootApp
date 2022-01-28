package com.mukeshsoft.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long id) {
		super(String.format("User with ID : %d Not Found",id));
		// TODO Auto-generated constructor stub
	}
	

}
