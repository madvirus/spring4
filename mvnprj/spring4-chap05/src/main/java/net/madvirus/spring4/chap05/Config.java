package net.madvirus.spring4.chap05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public static ThresholdRequiedBeanFactoryPostProcessor processor() {
		ThresholdRequiedBeanFactoryPostProcessor p = new ThresholdRequiedBeanFactoryPostProcessor();
		p.setDefaultThreshold(10);
		return p;
	}

	@Bean
	public DataCollector collector1() {
		DataCollector collector = new DataCollector();
		collector.setThreshold(5);
		return collector;
	}

	@Bean
	public DataCollector collector2() {
		DataCollector collector = new DataCollector();
		return collector;
	}
}
