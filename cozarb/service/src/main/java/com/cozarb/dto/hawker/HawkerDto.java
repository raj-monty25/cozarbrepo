package com.cozarb.dto.hawker;

import java.io.Serializable;

import com.cozarb.dto.productandcategories.ImageDto;

public class HawkerDto implements Serializable {
	protected int hawkerId;
	protected String hawkerName;
	protected String description;
	protected ImageDto hawkerImage;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImageDto getHawkerImage() {
		return hawkerImage;
	}

	public void setHawkerImage(ImageDto hawkerImage) {
		this.hawkerImage = hawkerImage;
	}

}
