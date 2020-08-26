package com.cozarb.dto.order;

import java.io.Serializable;
import java.util.Date;

public class PaymentTrackingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	protected long paymentTrackingId;
	protected int bookingId;
	protected int customerId;
	protected String gatewayTransactionId;
	protected String bankTransactionId;
	protected String bankName;
	protected String gatewayName;
	protected String bankResponseCode;
	protected String bankResponseMessage;
	protected String paymentMode;
	protected String mid;
	protected String status;
	protected Date createdDt;
	protected String createdBy;
	protected Date lastModifiedDt;
	protected String lastModifiedBy;

	public long getPaymentTrackingId() {
		return paymentTrackingId;
	}

	public void setPaymentTrackingId(long paymentTrackingId) {
		this.paymentTrackingId = paymentTrackingId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getGatewayTransactionId() {
		return gatewayTransactionId;
	}

	public void setGatewayTransactionId(String gatewayTransactionId) {
		this.gatewayTransactionId = gatewayTransactionId;
	}

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getBankResponseCode() {
		return bankResponseCode;
	}

	public void setBankResponseCode(String bankResponseCode) {
		this.bankResponseCode = bankResponseCode;
	}

	public String getBankResponseMessage() {
		return bankResponseMessage;
	}

	public void setBankResponseMessage(String bankResponseMessage) {
		this.bankResponseMessage = bankResponseMessage;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedDt() {
		return lastModifiedDt;
	}

	public void setLastModifiedDt(Date lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
