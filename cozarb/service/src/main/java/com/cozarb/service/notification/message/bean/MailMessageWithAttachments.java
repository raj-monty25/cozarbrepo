package com.cozarb.service.notification.message.bean;

import java.util.List;

import com.cozarb.service.notification.bean.Attachment;

public class MailMessageWithAttachments extends Message {
	protected String[] cc;
	protected String[] bcc;
	protected String subject;
	protected List<Attachment> attachments;

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

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
