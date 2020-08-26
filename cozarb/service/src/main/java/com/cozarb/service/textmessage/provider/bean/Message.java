package com.cozarb.service.textmessage.provider.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("num_parts")
	protected int numParts;
	protected String sender;
	protected String content;

	public int getNumParts() {
		return numParts;
	}

	public void setNumParts(int numParts) {
		this.numParts = numParts;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
