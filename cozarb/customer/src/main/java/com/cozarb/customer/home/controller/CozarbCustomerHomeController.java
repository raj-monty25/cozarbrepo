package com.cozarb.customer.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cozarb.dto.hawker.HawkerDto;
import com.cozarb.dto.merchant.MerchantStoreCategoryDto;
import com.cozarb.dto.merchant.MerchantStoreDto;
import com.cozarb.dto.merchant.MerchantStoreProductDto;
import com.cozarb.service.hawker.HawkerService;
import com.cozarb.service.merchant.MerchantService;
import com.cozarb.service.productandcategories.ProductAndCategoryService;

@Controller
public class CozarbCustomerHomeController {
	@Autowired
	private ProductAndCategoryService productAndCategoryService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private HawkerService hawkerService;

	@RequestMapping("/home")
	public String showHomePage(Model model) {
		List<MerchantStoreCategoryDto> merchantStoreCategoryDtos = null;
		List<MerchantStoreProductDto> merchantStoreProductDtos = null;
		List<MerchantStoreDto> merchantStoreDtos = null;
		List<HawkerDto> hawkerDtos = null;

		merchantStoreCategoryDtos = merchantService.getTopMerchantCategories(30);
		merchantStoreProductDtos = merchantService.getRecentMerchantProducts(30);
		merchantStoreDtos = merchantService.getRecentlyAddedMerchantStores(30);
		hawkerDtos = hawkerService.getRecentHawkers(30);

		model.addAttribute("topCategories", merchantStoreCategoryDtos);
		model.addAttribute("recentProducts", merchantStoreProductDtos);
		model.addAttribute("recentMerchantStores", merchantStoreDtos);
		model.addAttribute("hawkers", hawkerDtos);

		return "cozarb-customer-home";
	}

}
