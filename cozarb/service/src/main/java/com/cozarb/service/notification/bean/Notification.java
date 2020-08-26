package com.cozarb.service.notification.bean;

import java.util.List;
import java.util.Map;

import com.cozarb.service.notification.ReceiptType;

public class Notification {
	protected String from;
	protected Map<ReceiptType, List<String>> receipts;
	protected String templateName;
	protected Map<String, Object> notificationDataMap;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Map<ReceiptType, List<String>> getReceipts() {
		return receipts;
	}

	public void setReceipts(Map<ReceiptType, List<String>> receipts) {
		this.receipts = receipts;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Map<String, Object> getNotificationDataMap() {
		return notificationDataMap;
	}

	public void setNotificationDataMap(Map<String, Object> notificationDataMap) {
		this.notificationDataMap = notificationDataMap;
	}

}
