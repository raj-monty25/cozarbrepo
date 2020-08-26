package com.cozarb.dao.merchant;

import java.util.Date;
import java.util.List;

import com.cozarb.bo.merchant.MerchantStoreCategoryBo;
import com.cozarb.bo.merchant.MerchantStoreProductBo;
import com.cozarb.bo.merchant.MerchantStoreProductDetailsBo;
import com.cozarb.bo.merchant.MerchantStoreWithBusinessBo;

public interface MerchantDao {
	List<MerchantStoreCategoryBo> getTopMerchantCategoriesFromDate(Date fromDate);

	List<MerchantStoreProductBo> getRecentMerchantProductsFromDate(Date fromDate);

	List<MerchantStoreWithBusinessBo> getRecentlyAddedMerchantStoresFromDate(Date fromDate);

	MerchantStoreProductDetailsBo getMerchantStoreProduct(int productNo);

	List<MerchantStoreProductBo> getMerchantStoreProductsBySimilarCategoryProduct(int productId);
}
