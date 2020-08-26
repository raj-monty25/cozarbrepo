package com.cozarb.dto.productandcategories;

import java.io.Serializable;
import java.util.Date;

public class ProductFeedbackDto implements Serializable {
	protected int feedbackId;
	protected String feedbackUserName;
	protected int productId;
	protected String comments;
	protected int rating;
	protected Date feedbackPostedDate;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackUserName() {
		return feedbackUserName;
	}

	public void setFeedbackUserName(String feedbackUserName) {
		this.feedbackUserName = feedbackUserName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getFeedbackPostedDate() {
		return feedbackPostedDate;
	}

	public void setFeedbackPostedDate(Date feedbackPostedDate) {
		this.feedbackPostedDate = feedbackPostedDate;
	}

}
