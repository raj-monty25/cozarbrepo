package com.cozarb.service.notification.formatter;

import java.util.Map;

public interface MessageFormatter {
	String format(String templateName, Map<String, Object> dataMap);
}
