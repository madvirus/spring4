package net.madvirus.spring4.chap16.security;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import net.madvirus.spring4.chap16.custom.UserInfo;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
	public void authentication_success_using_jdbc() {
		Authentication auth = authenticationManager.authenticate(createAuthToken("admin", "asdf"));
		assertThat(auth.isAuthenticated(), equalTo(true));
	}

	private UsernamePasswordAuthenticationToken createAuthToken(String principal, String credentials) {
		return new UsernamePasswordAuthenticationToken(principal, credentials);
	}

	@Test
	public void authentication_success_using_Custom_UserDetailsService() {
		Authentication auth = authenticationManager.authenticate(createAuthToken("system", "sys"));
		assertThat(auth, instanceOf(UsernamePasswordAuthenticationToken.class));
		assertThat(auth.getName(), equalTo("system"));
		assertThat(auth.getPrincipal(), instanceOf(User.class));
		assertThat(auth.getCredentials(), nullValue());
		assertThat(auth.getDetails(), nullValue());
		assertThat(auth.getAuthorities(), hasSize(1));
		assertThat(auth.getAuthorities(),
				Matchers.<GrantedAuthority> contains(new SimpleGrantedAuthority("SYSTEM_USER")));
	}

	@Test
	public void authentication_success_using_Custom_AuthenticationProvider() {
		Authentication auth = authenticationManager.authenticate(createAuthToken("cron", "cronpw"));
		assertThat(auth, instanceOf(UsernamePasswordAuthenticationToken.class));
		assertThat(auth.getPrincipal(), instanceOf(UserInfo.class));
		assertThat(auth.getCredentials(), nullValue());
		assertThat(auth.getDetails(), nullValue());
		assertThat(auth.getAuthorities(), hasSize(1));
		assertThat(auth.getAuthorities(),
				Matchers.<GrantedAuthority> contains(new SimpleGrantedAuthority("SCHEDULER")));
	}

	@Test
	public void authentication_fail_Given_Bad_Password() {
		givenBadPasword_ThrowBadCredentialsEx("admin", "1111");
		givenBadPasword_ThrowBadCredentialsEx("system", "sys1");
	}

	private void givenBadPasword_ThrowBadCredentialsEx(String principal, String credentials) {
		try {
			authenticationManager.authenticate(createAuthToken(principal, credentials));
			fail("BadCredentialsException이 반드시 발샐해야 함");
		} catch (BadCredentialsException ex) {
		}
	}

	@Test(expected = BadCredentialsException.class)
	public void authentication_fail_Given_Bad_Username() {
		authenticationManager.authenticate(createAuthToken("admin123", "1234"));
	}
}
