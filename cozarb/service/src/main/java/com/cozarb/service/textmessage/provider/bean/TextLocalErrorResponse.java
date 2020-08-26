package com.cozarb.service.textmessage.provider.bean;

public class TextLocalErrorResponse {
	protected TextLocalError[] errors;
	protected String status;

	public TextLocalError[] getErrors() {
		return errors;
	}

	public void setErrors(TextLocalError[] errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
