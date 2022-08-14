package com.abc.asset.AssetManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	public static final long serialVersionITD = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}