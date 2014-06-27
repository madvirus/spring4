package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import net.madvirus.spring4.chap18.Calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UseInnserConfClassTest {

	@Resource(name = "calculator3")
	private Calculator calculator;

	@Test
	public void sum() {
		assertThat(calculator.sum(1, 2), equalTo(3L));
	}

	@Configuration
	public static class Config {
		@Bean
		public Calculator calculator3() {
			return new Calculator();
		}

	}
}
