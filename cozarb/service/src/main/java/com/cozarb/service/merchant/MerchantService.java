package com.cozarb.service.merchant;

import java.util.List;

import com.cozarb.dto.merchant.MerchantStoreCategoryDto;
import com.cozarb.dto.merchant.MerchantStoreDto;
import com.cozarb.dto.merchant.MerchantStoreProductDetailsDto;
import com.cozarb.dto.merchant.MerchantStoreProductDto;

public interface MerchantService {
	List<MerchantStoreCategoryDto> getTopMerchantCategories(int days);

	List<MerchantStoreProductDto> getRecentMerchantProducts(int days);

	List<MerchantStoreDto> getRecentlyAddedMerchantStores(int days);

	List<MerchantStoreProductDto> getMerchantProductsOfSimilarCategoryByProductId(int productId);

	MerchantStoreProductDetailsDto getMerchantStoreProductDetails(int productId);

}
