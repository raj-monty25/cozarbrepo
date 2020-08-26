package com.cozarb.service.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.cozarb.service.notification.converter.MessageConverter;
import com.cozarb.service.notification.converter.service.MessageConverterService;
import com.cozarb.service.notification.facade.DefaultNotificationFacade;
import com.cozarb.service.notification.facade.NotificationFacade;
import com.cozarb.service.notification.message.service.MessageService;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.cozarb.dao.*", "com.cozarb.service.*" })
public class CozarbServiceConfig implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Autowired
	private Environment env;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public VelocityEngine velocityEngine() {
		VelocityEngine velocityEngine = null;

		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("resource.loader", env.getProperty("velocity.resource.loader.type"));
		velocityEngine.setProperty("file.resource.loader.class", env.getProperty("velocity.resource.loader.class"));
		velocityEngine.setProperty("file.resource.loader.path", env.getProperty("velocity.resource.loader.path"));
		velocityEngine.setProperty("file.resource.loader.cache", env.getProperty("velocity.resource.loader.cache"));
		return velocityEngine;
	}

	@SuppressWarnings({ "rawtypes" })
	@Bean
	public MessageConverterService messageConverterService() {
		List<MessageConverter<?, ?>> messageConverters = null;
		MessageConverterService messageConverterService = null;
		Map<String, MessageConverter> messageConverterMap = null;

		messageConverterService = new MessageConverterService();
		messageConverterMap = applicationContext.getBeansOfType(MessageConverter.class, true, true);
		messageConverters = new ArrayList<>();
		for (MessageConverter<?, ?> messageConverter : messageConverterMap.values()) {
			messageConverters.add(messageConverter);
		}
		messageConverterService.setMessageConverters(messageConverters);

		return messageConverterService;
	}

	@SuppressWarnings("unchecked")
	@Bean
	@DependsOn("messageConverterService")
	public NotificationFacade mailNotificationFacade() {
		DefaultNotificationFacade notificationFacade = null;

		notificationFacade = new DefaultNotificationFacade();
		notificationFacade.setMessageConverterService(
				applicationContext.getBean("messageConverterService", MessageConverterService.class));
		notificationFacade.setMessageService(applicationContext.getBean("mailMessageService", MessageService.class));
		return notificationFacade;
	}

	@Bean
	@DependsOn("messageConverterService")
	public NotificationFacade textLocalNotificationFacade() {
		DefaultNotificationFacade notificationFacade = null;

		notificationFacade = new DefaultNotificationFacade();
		notificationFacade.setMessageConverterService(
				applicationContext.getBean("messageConverterService", MessageConverterService.class));
		notificationFacade
				.setMessageService(applicationContext.getBean("textLocalMessageService", MessageService.class));

		return notificationFacade;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
