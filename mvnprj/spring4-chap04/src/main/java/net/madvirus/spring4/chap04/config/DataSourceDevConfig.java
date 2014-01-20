package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JdbcConnectionProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataSourceDevConfig {

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
