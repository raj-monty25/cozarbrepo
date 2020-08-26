package com.cozarb.dto.merchant;

import java.io.Serializable;
import java.util.List;

import com.cozarb.dto.productandcategories.ImageDto;

public class MerchantStoreProductDto implements Serializable {
	protected int productId;
	protected String productName;
	protected double price;
	protected List<ImageDto> productImages;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ImageDto> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ImageDto> productImages) {
		this.productImages = productImages;
	}

}
