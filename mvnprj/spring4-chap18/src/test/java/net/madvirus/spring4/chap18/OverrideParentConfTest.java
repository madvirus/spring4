package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import net.madvirus.spring4.chap18.SystemLogger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(value="classpath:/springconf2.xml", inheritLocations=false)
public class OverrideParentConfTest extends AbstractCommonConfTest {

	@Autowired
	private ApplicationContext context;

	@Resource(name = "systemLogger")
	private SystemLogger logger;

	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	private PrintStream origin;

	@Before
	public void setupSystemOut() throws UnsupportedEncodingException {
		origin = System.out;
		System.setOut(new PrintStream(out, true, "utf-8"));
	}

	@Test
	public void logger() throws UnsupportedEncodingException {
		logger.log("test");
		assertThat(out.toString("utf-8").trim(), equalTo("test"));
	}

	@After
	public void cleanUpSystemOut() {
		System.setOut(origin);
	}
}
