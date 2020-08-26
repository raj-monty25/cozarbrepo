package com.cozarb.dto.merchant;

import java.io.Serializable;
import java.util.List;

import com.cozarb.dto.productandcategories.ImageDto;
import com.cozarb.dto.productandcategories.ProductFeedbackDto;

public class MerchantStoreProductDetailsDto implements Serializable {
	protected int productId;
	protected String merchantBusinessName;
	protected String title;
	protected String description;
	protected double price;
	protected int quantity;
	protected double rating;
	protected List<ProductFeedbackDto> productFeedback;
	protected List<ImageDto> productImages;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMerchantBusinessName() {
		return merchantBusinessName;
	}

	public void setMerchantBusinessName(String merchantBusinessName) {
		this.merchantBusinessName = merchantBusinessName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<ProductFeedbackDto> getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(List<ProductFeedbackDto> productFeedback) {
		this.productFeedback = productFeedback;
	}

	public List<ImageDto> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ImageDto> productImages) {
		this.productImages = productImages;
	}

}
