package com.cozarb.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cozarb.service.config.CozarbServiceConfig;
import com.cozarb.service.initializers.CozarbServiceApplicationContextInitializer;
import com.cozarb.service.logging.CozarbLogger;

@SpringBootApplication(scanBasePackages = "com.cozarb.customer.*")
@Import({ CozarbServiceConfig.class, CozarbWebConfigurer.class })
public class MerchantApplication extends SpringBootServletInitializer {
	private final static CozarbLogger cozarbLogger = CozarbLogger.getLogger(MerchantApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		cozarbLogger.info("Cozarb Merchant Application is deploying as Embedded Application");
		SpringApplication springApplication = new SpringApplicationBuilder(MerchantApplication.class)
				.initializers(new CozarbServiceApplicationContextInitializer()).build();
		springApplication.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		cozarbLogger.info("Cozarb Merchant Application is deploying as War Application");
		return builder.sources(MerchantApplication.class)
				.initializers(new CozarbServiceApplicationContextInitializer());

	}

	@Bean
	public CommandLineRunner testDatabase() {
		return (args) -> {
			jdbcTemplate.query("select * from user_role", (rs, num) -> {
				cozarbLogger.debug(rs.getString(2));
				return null;
			});
		};
	}
}
