package com.cozarb.customer.controller.order;

import java.util.Date;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cozarb.customer.security.bean.UserDetailsImpl;
import com.cozarb.dto.order.PaymentTrackingDto;
import com.cozarb.paytm.response.bean.PaytmResponseBean;
import com.cozarb.service.exception.CozarbError;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
@PropertySource("classpath:paytm-gateway.properties")
public class ManageCustomerOrderController {
	@Value("${MID}")
	protected String mid;
	@Value("${MERCHANT_KEY}")
	protected String merchantKey;
	@Value("${INDUSTRY_TYPE_ID}")
	protected String industryTypeId;
	@Value("${CHANNEL_ID}")
	protected String channelId;
	@Value("${WEBSITE}")
	protected String webSite;
	@Value("${PAYTM_URL}")
	protected String payTMUrl;
	@Value("${CALLBACK_URL}")
	protected String callbackUrl;

	@RequestMapping("/check-out")
	public String checkout() {
		return "checkout";
	}

	@RequestMapping("/order-overview")
	public String showOrderOverview() {
		return "payment";
	}

	@RequestMapping("/paytm-payment")
	public String processPayment(Model model) {
		PaymentTrackingDto paymentTrackingDto = null;
		String systemUserName = null;
		Object principle = null;
		String checkSum = null;
		int systemUserId = 0;
		UserDetailsImpl userDetails = null;

		principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principle instanceof UserDetails) {
			userDetails = (UserDetailsImpl) principle;
			systemUserName = userDetails.getUsername();
			systemUserId = userDetails.getSystemUserId();
		}

		checkSum = generateChecksum(1, systemUserId, 100);

		model.addAttribute("mid", mid);
		model.addAttribute("orderId", 1);
		model.addAttribute("customerId", systemUserId);
		model.addAttribute("industryTypeId", industryTypeId);
		model.addAttribute("channelId", channelId);
		model.addAttribute("transactionAmount", 100);
		model.addAttribute("website", webSite);
		model.addAttribute("callbackUrl", callbackUrl);
		model.addAttribute("payTMUrl", payTMUrl);
		model.addAttribute("paytmChecksum", checkSum);
		return "redirect-paytm";
	}

	@RequestMapping("/payment-response")
	public String paymentProcessedAndOrderCreated(@ModelAttribute PaytmResponseBean response, Model model) {
		if (response.getRESPCODE().equals("01")) {
			return "order-complete";
		}
		CozarbError error = new CozarbError("Payment Failed", "Your payment has been failed please retry");
		model.addAttribute("error", error);
		return "global-error";
	}

	private String generateChecksum(int orderId, int customerId, double amount) {
		TreeMap<String, String> parameters;
		String paytmChecksum = null;

		parameters = new TreeMap<String, String>();
		parameters.put("MID", mid);
		parameters.put("ORDER_ID", String.valueOf(orderId));
		parameters.put("CUST_ID", String.valueOf(customerId));
		parameters.put("INDUSTRY_TYPE_ID", industryTypeId);
		parameters.put("CHANNEL_ID", channelId);
		parameters.put("TXN_AMOUNT", String.valueOf(amount));
		parameters.put("WEBSITE", webSite);
		parameters.put("CALLBACK_URL", callbackUrl);

		try {
			paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return paytmChecksum;
	}
}
