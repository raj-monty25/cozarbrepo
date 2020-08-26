package com.cozarb.service.notification.bean;

import java.util.List;

public class MultimediaNotification extends Notification {
	protected String subject;
	protected List<Attachment> attachments;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
