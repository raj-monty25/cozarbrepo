package com.cozarb.service.initializers;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import com.cozarb.service.exception.CozarbServiceConfigException;
import com.cozarb.service.logging.CozarbLogger;

public class CozarbServiceApplicationContextInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	private static CozarbLogger cozarbLogger = CozarbLogger.getLogger(CozarbServiceApplicationContextInitializer.class);

	private final String SERVICE_CONFIG_YAML_FILE_NM = "cozarb-service-";

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Resource resource = null;
		String activeProfile = null;
		String configYamlLocation = null;
		List<PropertySource<?>> propertySources = null;
		ConfigurableEnvironment configurableEnvironment = null;
		YamlPropertySourceLoader yamlPropertySourceLoader = null;

		activeProfile = applicationContext.getEnvironment().getActiveProfiles()[0];
		cozarbLogger.info("activeProfile : {}", activeProfile);

		configYamlLocation = "classpath:/META-INF/" + SERVICE_CONFIG_YAML_FILE_NM + activeProfile + ".yaml";
		resource = applicationContext.getResource(configYamlLocation);
		yamlPropertySourceLoader = new YamlPropertySourceLoader();
		configurableEnvironment = applicationContext.getEnvironment();
		try {
			propertySources = yamlPropertySourceLoader.load("service-config", resource);
			for (PropertySource<?> propertySource : propertySources) {
				configurableEnvironment.getPropertySources().addLast(propertySource);
			}
		} catch (IOException e) {
			cozarbLogger.fatal("error while loading the service config yaml", e);
			throw new CozarbServiceConfigException("error while loading yaml into application context environment", e);
		}
	}
}
