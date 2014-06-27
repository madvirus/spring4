package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ReuseParentConfTest extends AbstractCommonConfTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void beanExists() {
		assertThat(context.containsBean("calculator"), equalTo(true));
	}
}
