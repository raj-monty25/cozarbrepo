package com.cozarb.service.exception;

public class ResourceNotFoundException extends CozarbServiceException {
	private static final long serialVersionUID = 1190534557272959268L;

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
