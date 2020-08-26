package com.cozarb.service.notification.converter.service;

import java.util.List;

import com.cozarb.service.notification.converter.MessageConverter;

public class MessageConverterService {
	private List<MessageConverter<?, ?>> messageConverters;

	public MessageConverter<?, ?> getMessageConverter(Class<?> sourceType, Class<?> targetType) {
		MessageConverter<?, ?> messageConverter = null;

		for (MessageConverter<?, ?> converter : messageConverters) {
			if (converter.isConvertable(sourceType, targetType)) {
				messageConverter = converter;
				break;
			}
		}

		return messageConverter;
	}

	public void setMessageConverters(List<MessageConverter<?, ?>> messageConverters) {
		this.messageConverters = messageConverters;
	}

}
