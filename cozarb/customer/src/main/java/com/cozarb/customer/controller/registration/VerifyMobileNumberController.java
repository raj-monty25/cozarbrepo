package com.cozarb.customer.controller.registration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cozarb.service.accountmanagement.UserManagementService;
import com.cozarb.service.constants.CozarbServiceConstants;
import com.cozarb.service.exception.CozarbError;
import com.cozarb.service.exception.MobileAlreadyVerifiedException;

@Controller
@RequestMapping("/verify-mobile-number")
public class VerifyMobileNumberController {
	@Autowired
	private UserManagementService userManagementService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/{userId}/{mobileNumber}")
	public String showVerifyMobileNumberPage(@PathVariable("userId") int userId,
			@PathVariable("mobileNumber") String mobileNumber, Model model) {

		model.addAttribute("systemUserId", userId);
		model.addAttribute("mobileNumber", mobileNumber);

		return "verify-mobile-number";
	}

	@PostMapping
	public String verifyMobileNumber(@RequestParam("systemUserId") int userId, @RequestParam("otp") String otp) {
		int verificationStatus = 0;
		String page = null;

		verificationStatus = userManagementService.verifyUserMobileNumber(userId, otp);
		if (verificationStatus == CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_MOBILE_ONLY_VERIFIED) {
			page = "mobile-verified";
		} else {
			page = "account-activated";
		}

		return page;
	}

	@ExceptionHandler
	public String handleMobileAlreadyVerifiedException(MobileAlreadyVerifiedException exception, Model model,
			Locale locale) {

		CozarbError error = new CozarbError(messageSource.getMessage("mobileAlreadyVerified.title", null, locale),
				messageSource.getMessage("mobileAlreadyVerified.message", null, locale));
		model.addAttribute("error", error);
		return "global-error";
	}
}
