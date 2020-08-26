package com.cozarb.service.exception;

public class MobileAlreadyVerifiedException extends CozarbServiceException {
	private static final long serialVersionUID = -7127193375865092813L;

	public MobileAlreadyVerifiedException(String message) {
		super(message);
	}

}
