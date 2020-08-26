package com.cozarb.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/indexC")
	public String showIndexPage() {
		return "checkout";
	}
}
