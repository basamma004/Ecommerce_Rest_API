package com.example.ecommerceproject.exceptionhandler;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException (String message) {
		super(message);
	}
}