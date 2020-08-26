package com.cozarb.bo.hawker;

import java.io.Serializable;
import java.util.Date;

import com.cozarb.bo.productandcategories.ImageBo;

public class HawkerBo implements Serializable {
	protected int hawkerId;
	protected String hawkerName;
	protected String displayName;
	protected String description;
	protected int hawkerAddressId;
	protected int hawkerContactInfoId;
	protected ImageBo hawkerImage;
	protected String status;
	protected String createdBy;
	protected Date createdDate;
	protected String lastModifiedBy;
	protected Date lastModifiedDate;

	public int getHawkerId() {
		return hawkerId;
	}

	public void setHawkerId(int hawkerId) {
		this.hawkerId = hawkerId;
	}

	public String getHawkerName() {
		return hawkerName;
	}

	public void setHawkerName(String hawkerName) {
		this.hawkerName = hawkerName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHawkerAddressId() {
		return hawkerAddressId;
	}

	public void setHawkerAddressId(int hawkerAddressId) {
		this.hawkerAddressId = hawkerAddressId;
	}

	public int getHawkerContactInfoId() {
		return hawkerContactInfoId;
	}

	public void setHawkerContactInfoId(int hawkerContactInfoId) {
		this.hawkerContactInfoId = hawkerContactInfoId;
	}

	public ImageBo getHawkerImage() {
		return hawkerImage;
	}

	public void setHawkerImage(ImageBo hawkerImage) {
		this.hawkerImage = hawkerImage;
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
