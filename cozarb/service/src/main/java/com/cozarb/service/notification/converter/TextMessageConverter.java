package com.cozarb.service.notification.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cozarb.service.notification.ReceiptType;
import com.cozarb.service.notification.bean.Notification;
import com.cozarb.service.notification.formatter.MessageFormatter;
import com.cozarb.service.notification.message.bean.Message;

@Component
public class TextMessageConverter implements MessageConverter<Notification, Message> {
	@Autowired
	private MessageFormatter messageFormatter;

	@Override
	public boolean isConvertable(Class<?> sourceType, Class<?> targetType) {
		if (sourceType == Notification.class && targetType == Message.class) {
			return true;
		}
		return false;
	}

	@Override
	public Message convert(Notification notification) {
		Message message = null;
		String content = null;

		content = messageFormatter.format(notification.getTemplateName(), notification.getNotificationDataMap());
		message = new Message();
		message.setFrom(notification.getFrom());
		message.setTo(notification.getReceipts().get(ReceiptType.TO).stream().toArray(String[]::new));
		message.setContent(content);

		return message;
	}

}
