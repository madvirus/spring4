package net.madvirus.spring4.chap05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext2.xml")
public class Config2 {

	@Bean
	public static ThresholdRequiedBeanFactoryPostProcessor processor() {
		ThresholdRequiedBeanFactoryPostProcessor p = new ThresholdRequiedBeanFactoryPostProcessor();
		p.setDefaultThreshold(10);
		return p;
	}
}
