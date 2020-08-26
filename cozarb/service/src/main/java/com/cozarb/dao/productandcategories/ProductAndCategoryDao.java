package com.cozarb.dao.productandcategories;

import java.util.List;

import com.cozarb.bo.merchant.MerchantStoreCategoryBo;

public interface ProductAndCategoryDao {
	byte[] getImage(int imageId);

	List<MerchantStoreCategoryBo> getMerchantStoreCategories();
}
