package com.cozarb.customer.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cozarb.dto.merchant.MerchantStoreProductDetailsDto;
import com.cozarb.dto.merchant.MerchantStoreProductDto;
import com.cozarb.service.merchant.MerchantService;

@Controller
public class ProductDetailsController {
	@Autowired
	private MerchantService merchantService;

	@RequestMapping("/{productId}/product-details")
	public String getProductDetails(@PathVariable("productId") int productId, Model model) {
		MerchantStoreProductDetailsDto merchantStoreProductDetailsDto = null;
		List<MerchantStoreProductDto> merchantStoreProductDtos = null;

		merchantStoreProductDetailsDto = merchantService.getMerchantStoreProductDetails(productId);
		merchantStoreProductDtos = merchantService.getMerchantProductsOfSimilarCategoryByProductId(productId);

		model.addAttribute("productDetails", merchantStoreProductDetailsDto);
		model.addAttribute("similarProducts", merchantStoreProductDtos);

		return "product-details";
	}
}
