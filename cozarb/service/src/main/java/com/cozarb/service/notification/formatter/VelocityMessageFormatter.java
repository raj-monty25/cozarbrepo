package com.cozarb.service.notification.formatter;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cozarb.service.logging.CozarbLogger;

@Component
public class VelocityMessageFormatter implements MessageFormatter {
	private final static CozarbLogger cozarbLogger = CozarbLogger.getLogger(VelocityMessageFormatter.class);

	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public String format(String templateName, Map<String, Object> dataMap) {
		String content = null;
		Template template = null;
		StringWriter writer = null;
		VelocityContext vContext = null;

		writer = new StringWriter();
		vContext = new VelocityContext();
		for (String key : dataMap.keySet()) {
			vContext.put(key, dataMap.get(key));
		}
		template = velocityEngine.getTemplate(templateName);
		template.merge(vContext, writer);
		content = writer.toString();

		cozarbLogger.debug("formatted message : " + content + " with template : " + templateName);

		return content;
	}

}
