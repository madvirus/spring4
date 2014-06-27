package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import net.madvirus.spring4.chap18.Calculator;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorBeanTest {

	private Calculator calculator;

	@Before
	public void setup() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:/springconf.xml");
		calculator = ctx.getBean(Calculator.class);
	}

	@Test
	public void sum() {
		assertThat(calculator.sum(1, 2), equalTo(3L));
	}
}
