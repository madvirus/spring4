package net.madvirus.spring4.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(@PropertySource("classpath:/db.properties"))
public class ConfigByEnv {

	@Autowired
	private Environment env;

	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		ConnectionProvider connectionProvider = new ConnectionProvider();
		connectionProvider.setDriver(env.getProperty("db.driver"));
		connectionProvider.setUrl(env.getProperty("db.jdbcUrl"));
		connectionProvider.setUser(env.getProperty("db.user"));
		connectionProvider.setPassword(env.getProperty("db.password"));
		return connectionProvider;
	}
}
