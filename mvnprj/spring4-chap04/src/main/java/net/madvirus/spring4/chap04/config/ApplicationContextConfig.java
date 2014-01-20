package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ChargeCalculator;
import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JdbcConnectionProvider;
import net.madvirus.spring4.chap04.JndiConnectionProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationContextConfig {

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

	@Configuration
	@Profile("!prod")
	public static class DataSourceDev {
		@Value("${db.driver}")
		private String driver;
		@Value("${db.jdbcUrl}")
		private String url;
		@Value("${db.user}")
		private String user;
		@Value("${db.password}")
		private String password;

		@Bean
		public ConnectionProvider connProvider() {
			JdbcConnectionProvider provider = new JdbcConnectionProvider();
			provider.setDriver(driver);
			provider.setUrl(url);
			provider.setUser(user);
			provider.setPassword(password);
			return provider;
		}
	}

	@Configuration
	@Profile("prod")
	public static class DataSourceProdConfig {

		@Bean
		public ConnectionProvider connProvider() {
			JndiConnectionProvider provider = new JndiConnectionProvider();
			provider.setJndiName("java:/comp/env/jdbc/db");
			return provider;
		}
	}
}
