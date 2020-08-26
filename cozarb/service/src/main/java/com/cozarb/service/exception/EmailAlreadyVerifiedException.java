package com.cozarb.service.exception;

public class EmailAlreadyVerifiedException extends CozarbServiceException {
	private static final long serialVersionUID = -1539298237730504695L;

	public EmailAlreadyVerifiedException(String message) {
		super(message);
	}

}
