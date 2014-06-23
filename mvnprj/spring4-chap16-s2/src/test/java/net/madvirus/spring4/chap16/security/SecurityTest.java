package net.madvirus.spring4.chap16.security;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring-security-s2.xml", "classpath:/spring-mvc-s2.xml" })
@WebAppConfiguration
public class SecurityTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void init() {
		DelegatingFilterProxy securityFilter = new DelegatingFilterProxy();
		securityFilter.setTargetBeanName("springSecurityFilterChain");
		securityFilter.setServletContext(context.getServletContext());
		mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(securityFilter, "/*").build();
	}

	@Test
	public void create_AuthCookie_When_Login_Success()
			throws Exception {
		MvcResult result = mockMvc
				.perform(post("/user/login").param("userid", "bkchoi").param("password", "1234"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andExpect(cookie().value("AUTH", urlencode("bkchoi,ROLE_USER")))
				.andReturn();
		assertThat(result.getRequest().getSession(false), nullValue());
	}

	@Test
	public void given_AuthCookie_Then_Can_Access_Restricted_Path()
			throws Exception {
		MvcResult result = mockMvc
				.perform(get("/member/main").cookie(new Cookie("AUTH", urlencode("bkchoi,ROLE_USER"))))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		assertThat(result.getRequest().getSession(false), nullValue());
	}

	@Test
	public void delete_AuthCookie_When_Logout()
			throws Exception {
		String contextPath = "/spring4-chap16-s2";
		mockMvc
				.perform(
						get(contextPath + "/user/logout").cookie(new Cookie("AUTH", urlencode("bkchoi,ROLE_USER")))
								.contextPath(contextPath))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(contextPath + "/"))
				.andExpect(cookie().maxAge("AUTH", 0))
				.andExpect(cookie().path("AUTH", "/"))
				.andReturn();
	}

	private String urlencode(String string) {
		try {
			return URLEncoder.encode(string, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
