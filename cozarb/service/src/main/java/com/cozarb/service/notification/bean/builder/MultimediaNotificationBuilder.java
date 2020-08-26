package com.cozarb.service.notification.bean.builder;

import java.util.ArrayList;
import java.util.List;

import com.cozarb.service.notification.ReceiptType;
import com.cozarb.service.notification.bean.Attachment;
import com.cozarb.service.notification.bean.MultimediaNotification;
import com.cozarb.service.notification.bean.Notification;

public class MultimediaNotificationBuilder extends NotificationBuilder {
	protected String subject;
	protected List<Attachment> attachments;

	public MultimediaNotificationBuilder(String from, String templateName, String toAddress) {
		super(from, templateName, toAddress);
		this.attachments = new ArrayList<>();
	}

	public MultimediaNotificationBuilder cc(String ccAddress) {
		List<String> ccAddresses = null;

		if (receipts.get(ReceiptType.CC) == null) {
			receipts.put(ReceiptType.CC, new ArrayList<>());
		}
		ccAddresses = receipts.get(ReceiptType.CC);
		ccAddresses.add(ccAddress);
		return this;
	}

	public MultimediaNotificationBuilder bcc(String bccAddress) {
		List<String> bccAddresses = null;

		if (receipts.get(ReceiptType.BCC) == null) {
			receipts.put(ReceiptType.BCC, new ArrayList<>());
		}
		bccAddresses = receipts.get(ReceiptType.BCC);
		bccAddresses.add(bccAddress);
		return this;
	}

	public MultimediaNotificationBuilder subject(String subject) {
		this.subject = subject;
		return this;
	}

	public MultimediaNotificationBuilder addAttachment(String attachmentName, byte[] content, String mediaType) {
		Attachment attachment = null;

		attachment = new Attachment();
		attachment.setAttachmentName(attachmentName);
		attachment.setContent(content);
		attachment.setMediaType(mediaType);
		attachments.add(attachment);

		return this;
	}

	public MultimediaNotificationBuilder addInlineAttachment(String attachmentName, byte[] content, String cid, String mediaType) {
		Attachment attachment = null;

		attachment = new Attachment();
		attachment.setAttachmentName(attachmentName);
		attachment.setContent(content);
		attachment.setCid(cid);
		attachment.setMediaType(mediaType);
		
		attachments.add(attachment);

		return this;
	}

	public Notification build() {
		MultimediaNotification notification = null;

		notification = new MultimediaNotification();
		notification.setFrom(from);
		notification.setReceipts(receipts);
		notification.setTemplateName(templateName);
		notification.setNotificationDataMap(notificationDataMap);
		notification.setSubject(subject);
		notification.setAttachments(attachments);

		return notification;
	}
}
