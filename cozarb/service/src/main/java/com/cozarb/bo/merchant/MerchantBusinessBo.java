package com.cozarb.bo.merchant;

import java.io.Serializable;
import java.util.Date;

public class MerchantBusinessBo implements Serializable {
	protected int merchantBusinessId;
	protected String businessName;
	protected String businessAliasName;
	protected String businessLicenseNo;
	protected String licenseIssuedAuthority;
	protected Date licenseIssuedDate;
	protected int businessAddressId;
	protected int primaryContactInfoId;
	protected int secondaryContactInfoId;
	protected String status;
	protected String createdBy;
	protected Date createdDate;
	protected String lastModifiedBy;
	protected Date lastModifiedDate;

	public int getMerchantBusinessId() {
		return merchantBusinessId;
	}

	public void setMerchantBusinessId(int merchantBusinessId) {
		this.merchantBusinessId = merchantBusinessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAliasName() {
		return businessAliasName;
	}

	public void setBusinessAliasName(String businessAliasName) {
		this.businessAliasName = businessAliasName;
	}

	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}

	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}

	public String getLicenseIssuedAuthority() {
		return licenseIssuedAuthority;
	}

	public void setLicenseIssuedAuthority(String licenseIssuedAuthority) {
		this.licenseIssuedAuthority = licenseIssuedAuthority;
	}

	public Date getLicenseIssuedDate() {
		return licenseIssuedDate;
	}

	public void setLicenseIssuedDate(Date licenseIssuedDate) {
		this.licenseIssuedDate = licenseIssuedDate;
	}

	public int getBusinessAddressId() {
		return businessAddressId;
	}

	public void setBusinessAddressId(int businessAddressId) {
		this.businessAddressId = businessAddressId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
