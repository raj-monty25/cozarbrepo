package com.cozarb.service.notification.bean.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cozarb.service.notification.ReceiptType;
import com.cozarb.service.notification.bean.Notification;

public class NotificationBuilder {
	protected String from;
	protected Map<ReceiptType, List<String>> receipts;
	protected String templateName;
	protected Map<String, Object> notificationDataMap;

	public NotificationBuilder(String from, String templateName, String toAddress) {
		List<String> toAddresses = null;

		this.from = from;
		this.templateName = templateName;
		receipts = new HashMap<>();
		notificationDataMap = new HashMap<>();

		toAddresses = new ArrayList<>();
		toAddresses.add(toAddress);
		receipts.put(ReceiptType.TO, toAddresses);
	}

	public NotificationBuilder to(String toAddress) {
		List<String> toAddresses = null;
		toAddresses = receipts.get(ReceiptType.TO);
		toAddresses.add(toAddress);
		return this;
	}

	public NotificationBuilder attribute(String attributeName, Object attributeValue) {
		notificationDataMap.put(attributeName, attributeValue);
		return this;
	}

	public Notification build() {
		Notification notification = null;

		notification = new Notification();
		notification.setFrom(from);
		notification.setReceipts(receipts);
		notification.setTemplateName(templateName);
		notification.setNotificationDataMap(notificationDataMap);

		return notification;
	}
}
