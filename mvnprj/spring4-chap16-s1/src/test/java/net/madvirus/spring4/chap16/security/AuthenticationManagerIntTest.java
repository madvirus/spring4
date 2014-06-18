package net.madvirus.spring4.chap16.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@ContextConfiguration({ "classpath:/spring-security-s1.xml", "classpath:/spring-application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "/UserAuthorities.xml")
public class AuthenticationManagerIntTest {

	@Autowired
	AuthenticationManager authenticationManager;

	@Test
	public void authentication_success() {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin", "asdf"));
	}

	@Test(expected = BadCredentialsException.class)
	public void authentication_fail_Given_Bad_Password() {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin", "1111"));
	}

	@Test(expected = BadCredentialsException.class)
	public void authentication_fail_Given_Bad_Username() {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin123", "1234"));
	}
}
