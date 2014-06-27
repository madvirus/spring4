package net.madvirus.spring4.chap18;

import net.madvirus.spring4.chap18.Calculator;
import net.madvirus.spring4.chap18.SystemLogger;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("dev")
public abstract class CommonActiveProfileTest {

	@Configuration
	@Profile("dev")
	public static class Conf1 {
		@Bean
		public Calculator calculator() {
			return new Calculator();
		}
	}

	@Configuration
	@Profile("local")
	public static class Conf2 {
		@Bean
		public SystemLogger calculator2() {
			return new SystemLogger();
		}
	}
}
