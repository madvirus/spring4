package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import net.madvirus.spring4.chap18.Calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UseDefaultConfigXmlTest {

	@Resource(name = "calculator2")
	private Calculator calculator;

	@Test
	public void sum() {
		assertThat(calculator.sum(1, 2), equalTo(3L));
	}
}
