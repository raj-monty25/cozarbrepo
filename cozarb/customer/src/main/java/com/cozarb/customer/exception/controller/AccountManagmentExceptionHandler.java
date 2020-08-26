package com.cozarb.customer.exception.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cozarb.service.exception.AccountAlreadyActivatedException;
import com.cozarb.service.exception.CozarbError;
import com.cozarb.service.exception.VerificationCodeMisMatchException;

@ControllerAdvice
public class AccountManagmentExceptionHandler {
	@ExceptionHandler
	public String handleAccountAlreadyActivatedException(AccountAlreadyActivatedException exception, Model model) {
		CozarbError error = new CozarbError("Account already active",
				"Your account is already active, please procced for login");
		model.addAttribute("error", error);

		return "global-error";
	}

	@ExceptionHandler
	public String handleVerificationCodeMisMatchException(VerificationCodeMisMatchException exception, Model model) {
		CozarbError error = new CozarbError("Verification Code Mis-Matched",
				"Your verification code is wrong, please use the link we sent to your email address for verification or enter the otp we sent to your mobile number");
		model.addAttribute("error", error);
		return "global-error";
	}

	@ExceptionHandler
	public String handleAccountNotFoundException(AccountNotFoundException exception, Model model) {
		CozarbError error = new CozarbError("Oops! Account Not Found",
				"Sorry, We couldn't able to find your account, please reach to the customer care for support");
		model.addAttribute("error", error);
		return "global-error";
	}
}
