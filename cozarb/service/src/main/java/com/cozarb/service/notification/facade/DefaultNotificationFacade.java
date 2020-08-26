package com.cozarb.service.notification.facade;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.cozarb.service.exception.CozarbServiceException;
import com.cozarb.service.logging.CozarbLogger;
import com.cozarb.service.notification.bean.Notification;
import com.cozarb.service.notification.converter.MessageConverter;
import com.cozarb.service.notification.converter.service.MessageConverterService;
import com.cozarb.service.notification.message.bean.Message;
import com.cozarb.service.notification.message.service.MessageService;

public class DefaultNotificationFacade implements NotificationFacade {
	private final static CozarbLogger cozarbLogger = CozarbLogger.getLogger(DefaultNotificationFacade.class);
	private MessageService<Message> messageService;
	private MessageConverterService messageConverterService;

	@SuppressWarnings("unchecked")
	@Override
	public void notify(Notification notification) {
		MessageConverter<Notification, Message> messageConverter = null;
		Class<?> sourceType = null;
		Class<?> targetType = null;
		Message message = null;

		sourceType = notification.getClass();
		cozarbLogger.debug("sourceType : " + sourceType.getCanonicalName());
		Type[] types = messageService.getClass().getGenericInterfaces();
		try {
			targetType = Class.forName(((ParameterizedType) types[0]).getActualTypeArguments()[0].getTypeName());

			cozarbLogger.debug("targetType : " + targetType.getCanonicalName());
			messageConverter = (MessageConverter<Notification, Message>) messageConverterService
					.getMessageConverter(sourceType, targetType);
			message = messageConverter.convert(notification);
			messageService.message(message);
		} catch (ClassNotFoundException e) {
			throw new CozarbServiceException("failed to resolve the generic Type of Message Service", e);
		}

	}

	public void setMessageService(MessageService<Message> messageService) {
		this.messageService = messageService;
	}

	public void setMessageConverterService(MessageConverterService messageConverterService) {
		this.messageConverterService = messageConverterService;
	}

}
