package com.cozarb.dto.merchant;

import java.io.Serializable;

import com.cozarb.dto.productandcategories.ImageDto;

public class MerchantStoreCategoryDto implements Serializable {
	protected int categoryId;
	protected String categoryName;
	protected ImageDto categoryImage;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ImageDto getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(ImageDto categoryImage) {
		this.categoryImage = categoryImage;
	}

}
