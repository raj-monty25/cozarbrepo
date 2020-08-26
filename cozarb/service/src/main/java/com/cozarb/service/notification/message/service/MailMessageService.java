package com.cozarb.service.notification.message.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.Message.RecipientType;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.cozarb.service.notification.bean.Attachment;
import com.cozarb.service.notification.message.bean.MailMessageWithAttachments;

@Component
public class MailMessageService implements MessageService<MailMessageWithAttachments> {
	@Autowired
	private JavaMailSender javaMailSender;

	
	public MailMessageService() {
		System.out.println("mail message service created...");
	}


	@Override
	public void message(final MailMessageWithAttachments message) {
		javaMailSender.send((mimeMessage) -> {
			MimeMessageHelper mimeMessageHelper = null;

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessage.setFrom(message.getFrom());
			mimeMessage.setRecipients(RecipientType.TO, Stream.of(message.getTo()).collect(Collectors.joining(";")));
			if (message.getCc() != null && message.getCc().length > 0) {
				mimeMessage.setRecipients(RecipientType.CC,
						Stream.of(message.getCc()).collect(Collectors.joining(";")));
			}
			if (message.getBcc() != null && message.getBcc().length > 0) {
				mimeMessage.setRecipients(RecipientType.BCC,
						Stream.of(message.getBcc()).collect(Collectors.joining(";")));
			}
			mimeMessage.setSubject(message.getSubject());
			mimeMessageHelper.setText(message.getContent(), true);
			for (Attachment attachment : message.getAttachments()) {
				if (attachment.getCid() == null || attachment.getCid().trim().length() == 0) {
					mimeMessageHelper.addAttachment(attachment.getAttachmentName(),
							new ByteArrayDataSource(attachment.getContent(), attachment.getMediaType()));
				} else {
					mimeMessageHelper.addInline(attachment.getCid(),
							new ByteArrayDataSource(attachment.getContent(), attachment.getMediaType()));
				}
			}
		});
	}

}
