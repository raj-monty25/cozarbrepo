package com.cozarb.service.notification.converter;

public interface MessageConverter<T, V> {
	boolean isConvertable(Class<?> sourceType, Class<?> targetType);

	V convert(T t);
}
