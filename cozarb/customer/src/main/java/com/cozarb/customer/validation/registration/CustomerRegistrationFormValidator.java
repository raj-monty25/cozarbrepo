package com.cozarb.customer.validation.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cozarb.customer.form.registration.CustomerRegistrationForm;
import com.cozarb.service.accountmanagement.UserManagementService;

@Component
public class CustomerRegistrationFormValidator implements Validator {
	@Autowired
	private UserManagementService userManagementService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CustomerRegistrationForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerRegistrationForm form = null;
		boolean emailAddressAvailable = false;

		form = (CustomerRegistrationForm) target;
		if (errors.hasFieldErrors("emailAddress") == false) {
			emailAddressAvailable = userManagementService.isEmailAddressAvailable(form.getEmailAddress());
			if (emailAddressAvailable == false) {
				errors.rejectValue("emailAddress", "emailAddress.notAvailable");
			}
		}

		if (errors.hasFieldErrors("password") == false) {
			if (form.getPassword().equals(form.getReTypePassword()) == false) {
				errors.rejectValue("reTypePassword", "reTypePassword.mismatch");
			}
		}

	}

}
