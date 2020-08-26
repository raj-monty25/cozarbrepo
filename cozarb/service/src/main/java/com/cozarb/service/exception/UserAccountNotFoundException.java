package com.cozarb.service.exception;

public class UserAccountNotFoundException extends CozarbServiceException {
	private static final long serialVersionUID = 2278064847854561946L;

	public UserAccountNotFoundException(String message) {
		super(message);
	}

	public UserAccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
