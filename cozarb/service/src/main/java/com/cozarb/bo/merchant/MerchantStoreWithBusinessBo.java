package com.cozarb.bo.merchant;

public class MerchantStoreWithBusinessBo extends MerchantStoreBo {
	protected MerchantBusinessBo merchantBusinessBo;

	public MerchantBusinessBo getMerchantBusinessBo() {
		return merchantBusinessBo;
	}

	public void setMerchantBusinessBo(MerchantBusinessBo merchantBusinessBo) {
		this.merchantBusinessBo = merchantBusinessBo;
	}

}
