package com.cozarb.service.notification.message.service;

import com.cozarb.service.notification.message.bean.Message;

public interface MessageService<T extends Message> {
	void message(T message);
}
