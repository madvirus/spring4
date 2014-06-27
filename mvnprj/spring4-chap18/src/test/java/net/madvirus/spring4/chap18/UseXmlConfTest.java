package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import net.madvirus.spring4.chap18.Calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/springconf.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UseXmlConfTest {
	@Autowired
	private Calculator calculator;

	@Test
	public void sum() {
		assertThat(calculator.sum(1, 2), equalTo(3L));
	}
	
	@Test
	public void sum1() {
		assertThat(calculator.sum(3, 4), equalTo(7L));
	}

	@Test
	public void sum2() {
		assertThat(calculator.sum(5, 6), equalTo(11L));
	}
	
}
