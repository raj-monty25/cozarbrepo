package com.cozarb.service.exception;

public class MessageServiceException extends CozarbServiceException {
	private static final long serialVersionUID = -7943715179278145017L;

	public MessageServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageServiceException(String message) {
		super(message);
	}

}
