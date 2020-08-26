package com.cozarb.bo.merchant;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cozarb.bo.productandcategories.ImageBo;

public class MerchantStoreBo implements Serializable {
	protected int merchantStoreId;
	protected int merchantBusinessId;
	protected int merchantStoreAddressId;
	protected int storeContactInfoId;
	protected int primaryContactInfoId;
	protected int secondaryContactInfoId;
	protected int storeOpeningTimeInHours;
	protected int storeClosingTimeInHours;
	protected int storeClosingTimeInMinutes;
	protected int storeOpeningTimeInMinutes;
	protected String status;
	protected List<ImageBo> storeImages;
	protected String createdBy;
	protected Date createdDate;
	protected String lastModifiedBy;
	protected Date lastModifiedDate;

	public int getMerchantStoreId() {
		return merchantStoreId;
	}

	public void setMerchantStoreId(int merchantStoreId) {
		this.merchantStoreId = merchantStoreId;
	}

	public int getMerchantBusinessId() {
		return merchantBusinessId;
	}

	public void setMerchantBusinessId(int merchantBusinessId) {
		this.merchantBusinessId = merchantBusinessId;
	}

	public int getMerchantStoreAddressId() {
		return merchantStoreAddressId;
	}

	public void setMerchantStoreAddressId(int merchantStoreAddressId) {
		this.merchantStoreAddressId = merchantStoreAddressId;
	}

	public int getStoreContactInfoId() {
		return storeContactInfoId;
	}

	public void setStoreContactInfoId(int storeContactInfoId) {
		this.storeContactInfoId = storeContactInfoId;
	}

	public int getPrimaryContactInfoId() {
		return primaryContactInfoId;
	}

	public void setPrimaryContactInfoId(int primaryContactInfoId) {
		this.primaryContactInfoId = primaryContactInfoId;
	}

	public int getSecondaryContactInfoId() {
		return secondaryContactInfoId;
	}

	public void setSecondaryContactInfoId(int secondaryContactInfoId) {
		this.secondaryContactInfoId = secondaryContactInfoId;
	}

	public int getStoreOpeningTimeInHours() {
		return storeOpeningTimeInHours;
	}

	public void setStoreOpeningTimeInHours(int storeOpeningTimeInHours) {
		this.storeOpeningTimeInHours = storeOpeningTimeInHours;
	}

	public int getStoreClosingTimeInHours() {
		return storeClosingTimeInHours;
	}

	public void setStoreClosingTimeInHours(int storeClosingTimeInHours) {
		this.storeClosingTimeInHours = storeClosingTimeInHours;
	}

	public int getStoreClosingTimeInMinutes() {
		return storeClosingTimeInMinutes;
	}

	public void setStoreClosingTimeInMinutes(int storeClosingTimeInMinutes) {
		this.storeClosingTimeInMinutes = storeClosingTimeInMinutes;
	}

	public int getStoreOpeningTimeInMinutes() {
		return storeOpeningTimeInMinutes;
	}

	public void setStoreOpeningTimeInMinutes(int storeOpeningTimeInMinutes) {
		this.storeOpeningTimeInMinutes = storeOpeningTimeInMinutes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ImageBo> getStoreImages() {
		return storeImages;
	}

	public void setStoreImages(List<ImageBo> storeImages) {
		this.storeImages = storeImages;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
