package com.cozarb.service.productandcategories;

import java.util.List;

import com.cozarb.dto.merchant.MerchantStoreCategoryDto;
import com.cozarb.dto.productandcategories.ImageDto;

public interface ProductAndCategoryService {
	byte[] getImage(int imageId);
	List<MerchantStoreCategoryDto> getMerchantStoreCategories();
}
