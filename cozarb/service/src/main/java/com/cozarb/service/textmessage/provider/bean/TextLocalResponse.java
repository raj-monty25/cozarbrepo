package com.cozarb.service.textmessage.provider.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextLocalResponse {
	@JsonProperty("test_mode")
	protected boolean testMode;
	protected int balance;
	@JsonProperty("batch_id")
	protected int batchId;
	protected int cost;
	@JsonProperty("num_messages")
	protected int numMessages;
	protected Message message;
	@JsonProperty("receipt_url")
	protected String receiptUrl;
	protected String custom;
	protected RecipientMessage[] messages;
	protected String status;

	public boolean isTestMode() {
		return testMode;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumMessages() {
		return numMessages;
	}

	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getReceiptUrl() {
		return receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public RecipientMessage[] getMessages() {
		return messages;
	}

	public void setMessages(RecipientMessage[] messages) {
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
