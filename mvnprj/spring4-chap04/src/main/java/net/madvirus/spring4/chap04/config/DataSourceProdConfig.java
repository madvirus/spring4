package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JndiConnectionProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DataSourceProdConfig {

	@Bean
	public ConnectionProvider connProvider() {
		JndiConnectionProvider provider = new JndiConnectionProvider();
		provider.setJndiName("java:/comp/env/jdbc/db");
		return provider;
	}
}
