package net.madvirus.spring4.chap16.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

@ContextConfiguration({ "classpath:/spring-security-s1.xml", "classpath:/spring-application.xml",
		"classpath:/spring-mvc-s1.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "/UserAuthorities.xml")
public class JoinControllerIntTest {

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
	public void return_FormView_By_Get() throws Exception {
		mockMvc.perform(get("/user/join"))
				.andDo(print())
				.andExpect(view().name(JoinController.USER_JOIN_FORM));
	}

	@Test
	public void return_FormView_By_Post_With_DuplicateName() throws Exception {
		mockMvc.perform(createPostRequest("bkchoi", "1111", "1111"))
				.andDo(print())
				.andExpect(view().name(JoinController.USER_JOIN_FORM));
	}

	private MockHttpServletRequestBuilder createPostRequest(String name, String password, String confirm) {
		return post("/user/join")
				.param("name", name)
				.param("password", password)
				.param("confirm", confirm);
	}

	@Test
	public void return_FormView_By_Post_When_PasswordAndConfirm_Differ() throws Exception {
		mockMvc.perform(createPostRequest("bkchoi2", "1111", "1234"))
				.andDo(print())
				.andExpect(view().name(JoinController.USER_JOIN_FORM));
	}

	@Test
	@ExpectedDatabase(value = "NewUserAdded.xml", table = "users", query = "select * from users where username='madvirus'")
	public void return_SuccessView_By_Post_With_Valid_Param() throws Exception {
		mockMvc.perform(createPostRequest("madvirus", "1111", "1111"))
				.andDo(print())
				.andExpect(view().name(JoinController.USER_JOIN_SUCCESS));
	}
}
