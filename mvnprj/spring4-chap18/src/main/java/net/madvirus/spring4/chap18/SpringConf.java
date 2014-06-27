package net.madvirus.spring4.chap18;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConf {

	@Bean
	public Calculator calcuator() {
		return new Calculator();
	}
}
