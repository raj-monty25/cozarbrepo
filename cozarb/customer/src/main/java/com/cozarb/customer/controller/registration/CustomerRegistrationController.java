package com.cozarb.customer.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cozarb.customer.form.registration.CustomerRegistrationForm;
import com.cozarb.customer.validation.registration.CustomerRegistrationFormValidator;
import com.cozarb.dto.accountmanagement.CustomerRegistrationDto;
import com.cozarb.service.accountmanagement.UserManagementService;
import com.cozarb.service.logging.CozarbLogger;

@Controller
@RequestMapping("/register")
public class CustomerRegistrationController {
	private static final CozarbLogger cozarbLogger = CozarbLogger.getLogger(CustomerRegistrationController.class);

	private final String FORM_CUSTOMER_REGISTRATION = "customerRegistrationForm";
	private final String PAGE_CUSTOMER_REGISTRATION = "customer-registration";
	private final String PAGE_CUSTOMER_REGISTRATION_CONFIRM = "customer-registration-confirm";

	@Autowired
	private CustomerRegistrationFormValidator validator;
	@Autowired
	private UserManagementService userManagementService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		cozarbLogger.debug("initBinder()");
		binder.addValidators(validator);
	}

	@GetMapping
	public String showCustomerRegistrationForm(Model model) {
		CustomerRegistrationForm customerRegistrationForm = null;

		customerRegistrationForm = new CustomerRegistrationForm();
		model.addAttribute(FORM_CUSTOMER_REGISTRATION, customerRegistrationForm);

		return PAGE_CUSTOMER_REGISTRATION;
	}

	@PostMapping
	public String registerCustomer(@ModelAttribute(FORM_CUSTOMER_REGISTRATION) @Validated CustomerRegistrationForm form,
			BindingResult errors, Model model) {
		int systemUserId = 0;
		CustomerRegistrationDto customerRegistrationDto = null;

		if (errors.hasErrors()) {
			cozarbLogger.debug("found errors in merchant registration form");
			return PAGE_CUSTOMER_REGISTRATION;
		}

		customerRegistrationDto = new CustomerRegistrationDto();
		customerRegistrationDto.setEmailAddress(form.getEmailAddress());
		customerRegistrationDto.setMobileNumber(form.getMobileNumber());
		customerRegistrationDto.setPassword(form.getPassword());

		systemUserId = userManagementService.registerCustomer(customerRegistrationDto);
		cozarbLogger.debug("registered customer with id {}", systemUserId);

		model.addAttribute("systemUserId", systemUserId);
		model.addAttribute("mobileNumber",
				"xxxxxxxxx" + form.getMobileNumber().substring(form.getMobileNumber().length() - 3));
		

		return PAGE_CUSTOMER_REGISTRATION_CONFIRM;
	}

}
