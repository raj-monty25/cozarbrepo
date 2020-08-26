package com.cozarb.service.exception;

public class VerificationCodeMisMatchException extends CozarbServiceException {
	private static final long serialVersionUID = 7033259406065952472L;

	public VerificationCodeMisMatchException(String message) {
		super(message);
	}

}
