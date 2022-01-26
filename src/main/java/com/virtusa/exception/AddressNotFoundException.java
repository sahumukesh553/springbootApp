package com.virtusa.exception;

public class AddressNotFoundException extends RuntimeException{

	public AddressNotFoundException(Long id) {
		super(String.format("Address With ID : %id Not Found", id));
		// TODO Auto-generated constructor stub
	}

}
