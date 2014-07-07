package net.madvirus.spring4.chap18;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/springconf.xml", "classpath:/springconf2.xml" })
@WebAppConfiguration
public abstract class AbstractCommonConfTest {
}
