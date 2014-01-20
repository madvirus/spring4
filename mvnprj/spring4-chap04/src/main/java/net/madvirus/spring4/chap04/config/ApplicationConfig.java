package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ChargeCalculator;
import net.madvirus.spring4.chap04.ConnectionProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocations(new Resource[] {
				new ClassPathResource("db.properties"),
				new ClassPathResource("app.properties")
		});
		return configurer;
	}

	@Value("${calc.batchSize}")
	private int batchSize;
	@Autowired
	private ConnectionProvider connProvider;

	@Bean
	public ChargeCalculator chargeCalculator() {
		ChargeCalculator cal = new ChargeCalculator();
		cal.setBatchSize(batchSize);
		cal.setConnectionProvider(connProvider);
		return cal;
	}

}
