package com.cozarb.service.exception;

import java.io.Serializable;

public class CozarbError implements Serializable {
	protected String title;
	protected String message;

	public CozarbError(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
