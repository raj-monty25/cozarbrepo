package com.cozarb.service.exception;

public class AccountAlreadyActivatedException extends CozarbServiceException {
	private static final long serialVersionUID = -2452468679309046758L;

	public AccountAlreadyActivatedException(String message) {
		super(message);
	}

}
