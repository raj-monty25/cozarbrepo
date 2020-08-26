package com.cozarb.service.notification.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cozarb.service.notification.ReceiptType;
import com.cozarb.service.notification.bean.MultimediaNotification;
import com.cozarb.service.notification.formatter.MessageFormatter;
import com.cozarb.service.notification.message.bean.MailMessageWithAttachments;

@Component
public class MailMessageWithAttachmentsConverter
		implements MessageConverter<MultimediaNotification, MailMessageWithAttachments> {
	@Autowired
	private MessageFormatter messageFormatter;

	@Override
	public boolean isConvertable(Class<?> sourceType, Class<?> TargetType) {
		if (sourceType == MultimediaNotification.class && TargetType == MailMessageWithAttachments.class) {
			return true;
		}
		return false;
	}

	@Override
	public MailMessageWithAttachments convert(MultimediaNotification notification) {
		MailMessageWithAttachments mailMessageWithAttachments = null;
		String formattedMessage = null;

		mailMessageWithAttachments = new MailMessageWithAttachments();
		formattedMessage = messageFormatter.format(notification.getTemplateName(),
				notification.getNotificationDataMap());
		mailMessageWithAttachments.setFrom(notification.getFrom());
		mailMessageWithAttachments
				.setTo(notification.getReceipts().get(ReceiptType.TO).stream().toArray(String[]::new));

		if (notification.getReceipts().get(ReceiptType.CC) != null
				&& notification.getReceipts().get(ReceiptType.CC).size() > 0) {
			mailMessageWithAttachments
					.setCc(notification.getReceipts().get(ReceiptType.CC).stream().toArray(String[]::new));
		}
		if (notification.getReceipts().get(ReceiptType.BCC) != null
				&& notification.getReceipts().get(ReceiptType.BCC).size() > 0) {
			mailMessageWithAttachments
					.setBcc(notification.getReceipts().get(ReceiptType.BCC).stream().toArray(String[]::new));
		}
		mailMessageWithAttachments.setSubject(notification.getSubject());
		mailMessageWithAttachments.setContent(formattedMessage);
		mailMessageWithAttachments.setAttachments(notification.getAttachments());
		return mailMessageWithAttachments;
	}

}
