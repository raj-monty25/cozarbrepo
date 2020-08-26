package com.cozarb.customer.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CozarbCustomerLoginController {
	@RequestMapping("/customer-login")
	public String showLoginPage() {
		return "customer-login";
	}
}
