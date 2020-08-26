package com.cozarb.dto.merchant;

import java.io.Serializable;
import java.util.List;

import com.cozarb.dto.productandcategories.ImageDto;

public class MerchantStoreDto implements Serializable {
	protected int merchantStoreId;
	protected String businessName;
	protected List<ImageDto> merchantStoreImages;

	public int getMerchantStoreId() {
		return merchantStoreId;
	}

	public void setMerchantStoreId(int merchantStoreId) {
		this.merchantStoreId = merchantStoreId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public List<ImageDto> getMerchantStoreImages() {
		return merchantStoreImages;
	}

	public void setMerchantStoreImages(List<ImageDto> merchantStoreImages) {
		this.merchantStoreImages = merchantStoreImages;
	}

}
