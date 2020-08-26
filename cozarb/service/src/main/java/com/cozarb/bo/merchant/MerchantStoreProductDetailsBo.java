package com.cozarb.bo.merchant;

import java.util.List;

import com.cozarb.bo.productandcategories.ProductFeedbackBo;

public class MerchantStoreProductDetailsBo extends MerchantStoreProductBo {
	private static final long serialVersionUID = 843373348424775757L;
	protected MerchantBusinessBo merchantBusiness;
	protected List<ProductFeedbackBo> productFeedback;

	public MerchantBusinessBo getMerchantBusiness() {
		return merchantBusiness;
	}

	public void setMerchantBusiness(MerchantBusinessBo merchantBusiness) {
		this.merchantBusiness = merchantBusiness;
	}

	public List<ProductFeedbackBo> getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(List<ProductFeedbackBo> productFeedback) {
		this.productFeedback = productFeedback;
	}

}
