package com.mukeshsoft.exception;

public class NoDataFoundException extends RuntimeException{

	public NoDataFoundException(String model) {
		super("No "+model+" Data Found");
		// TODO Auto-generated constructor stub
	}

}
