package com.cozarb.bo.merchant;

import java.io.Serializable;
import java.util.Date;

import com.cozarb.bo.productandcategories.ImageBo;

public class MerchantStoreCategoryBo implements Serializable {
	private static final long serialVersionUID = 3859810847761812740L;
	protected int categoryId;
	protected int merchantStoreId;
	protected String categoryName;
	protected String description;
	protected String status;
	protected ImageBo merchantStoreCategoryImage;
	protected String createdBy;
	protected Date createdDate;
	protected String lastModifiedBy;
	protected Date lastModifiedDate;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getMerchantStoreId() {
		return merchantStoreId;
	}

	public void setMerchantStoreId(int merchantStoreId) {
		this.merchantStoreId = merchantStoreId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ImageBo getMerchantStoreCategoryImage() {
		return merchantStoreCategoryImage;
	}

	public void setMerchantStoreCategoryImage(ImageBo merchantStoreCategoryImage) {
		this.merchantStoreCategoryImage = merchantStoreCategoryImage;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
