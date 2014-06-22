package net.madvirus.spring4.chap16.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import net.madvirus.spring4.chap16.base.AbstractWebMvcIntTest;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;

public class LoginFormIntTest extends AbstractWebMvcIntTest {
	private static final String HTTP_LOCALHOST = "http://localhost";

	@Test
	public void test_Login_Success_Process_When_AnonymousUser_Access_To_Member_Main()
			throws Exception {
		MvcResult result = mockMvc.perform(get("/member/main"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(HTTP_LOCALHOST + "/user/loginform"))
				.andReturn();

		HttpSession session = result.getRequest().getSession(false);

		result = mockMvc.perform(
				post("/user/login").param("userid", "bkchoi").param("password", "1234")
						.session(toMock(session)))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(HTTP_LOCALHOST + "/member/main"))
				.andReturn();
	}

	private MockHttpSession toMock(HttpSession session) {
		if (session instanceof MockHttpSession)
			return (MockHttpSession) session;
		else
			return createMockHttpSessionFromSession(session);
	}

	private MockHttpSession createMockHttpSessionFromSession(HttpSession session) {
		if (session == null)
			return null;
		MockHttpSession mockSession = new MockHttpSession();
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String name = attrNames.nextElement();
			mockSession.setAttribute(name, session.getAttribute(name));
		}
		return mockSession;
	}

	@Test
	public void test_Login_Fail_Process() throws Exception {
		mockMvc.perform(
				post("/user/login").param("userid", "bkchoi").param("password", "badpassword"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/user/loginform?error=true"))
				.andReturn();
	}

}
