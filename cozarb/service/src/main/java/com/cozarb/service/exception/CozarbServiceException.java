package com.cozarb.service.exception;

public class CozarbServiceException extends RuntimeException {

	public CozarbServiceException() {
		super();
	}

	public CozarbServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CozarbServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public CozarbServiceException(String message) {
		super(message);
	}

	public CozarbServiceException(Throwable cause) {
		super(cause);
	}

}
