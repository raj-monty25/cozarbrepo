package com.cozarb.dto.accountmanagement;

import java.io.Serializable;

public class CustomerRegistrationDto implements Serializable {
	private static final long serialVersionUID = 116691806607680825L;
	protected String emailAddress;
	protected String mobileNumber;
	protected String password;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
