package net.madvirus.spring4.chap16.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring-security.xml", "classpath:/spring-mvc.xml" })
@WebAppConfiguration
public class SecurityTest {
	private static final String HTTP_LOCALHOST = "http://localhost";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private MockHttpSession mockSession;

	@Before
	public void init() {
		DelegatingFilterProxy securityFilter = new DelegatingFilterProxy();
		securityFilter.setTargetBeanName("springSecurityFilterChain");
		securityFilter.setServletContext(context.getServletContext());
		mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(securityFilter, "/*").build();
		mockSession = new MockHttpSession();
	}

	@Test
	public void test_Successfully_Login_Redirect_Process_When_AnonymousUser_Access_To_Restricted_Resource()
			throws Exception {
		mockMvc.perform(get("/admin/main").session(mockSession))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(HTTP_LOCALHOST + "/spring_security_login"));

		dumpSession(mockSession);

		MvcResult result = mockMvc.perform(
				post("/j_spring_security_check").param("j_username", "admin").param("j_password", "asdf")
						.session(mockSession))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(HTTP_LOCALHOST + "/admin/main"))
				.andReturn();

		dumpSession(result.getRequest().getSession(false));
	}

	private void dumpSession(HttpSession session) {
		System.out.println("=========================== dump Session:" + session);
		if (session == null) {
			System.out.println("null session");
		} else {
			Enumeration<String> enums = session.getAttributeNames();
			while (enums.hasMoreElements()) {
				String name = enums.nextElement();
				System.out.printf("%s = %s\n", name, session.getAttribute(name));
			}
		}
		System.out.println("=========================== dump Session ==");
	}

}
