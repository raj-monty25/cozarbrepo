package com.cozarb.customer.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cozarb.service.productandcategories.ProductAndCategoryService;

@RestController
public class ProductAndCategoryImageController {
	@Autowired
	private ProductAndCategoryService ProductAndCategoryService;

	@RequestMapping("{imageId}/image")
	public byte[] getProductOrCategoryImageByImageId(@PathVariable("imageId") int imageId) {
		return ProductAndCategoryService.getImage(imageId);
	}

}
