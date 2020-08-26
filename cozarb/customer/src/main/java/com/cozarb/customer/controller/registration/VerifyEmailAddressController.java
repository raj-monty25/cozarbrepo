package com.cozarb.customer.controller.registration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cozarb.service.accountmanagement.UserManagementService;
import com.cozarb.service.constants.CozarbServiceConstants;
import com.cozarb.service.exception.CozarbError;
import com.cozarb.service.exception.EmailAlreadyVerifiedException;

@Controller
public class VerifyEmailAddressController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserManagementService userManagementService;

	@RequestMapping("/{userId}/{emailVerificationCode}/verify-email")
	public String verifyEmail(@PathVariable("userId") int systemUserId,
			@PathVariable("emailVerificationCode") String emailVerificationCode) {
		String page = null;
		int verificationStatus = 0;

		verificationStatus = userManagementService.verifyUserEmailAddress(systemUserId, emailVerificationCode);
		if (verificationStatus == CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_EMAIL_ONLY_VERIFIED) {
			page = "email-verified";
		} else if (verificationStatus == CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_ALL) {
			page = "account-activated";
		}
		return page;
	}

	@ExceptionHandler
	public String handleEmailAlreadyVerifiedException(EmailAlreadyVerifiedException exception, Model model,
			Locale locale) {
		CozarbError error = new CozarbError(messageSource.getMessage("emailAlreadyVerified.title", null, locale),
				messageSource.getMessage("emailAlreadyVerified.message", null, locale));
		model.addAttribute("error", error);
		return "global-error";
	}
}
