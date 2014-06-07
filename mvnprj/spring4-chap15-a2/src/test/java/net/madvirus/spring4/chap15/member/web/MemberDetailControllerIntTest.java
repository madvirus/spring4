package net.madvirus.spring4.chap15.member.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import net.madvirus.spring4.chap15.conf.SpringAppConfig;
import net.madvirus.spring4.chap15.conf.SpringMvcConfig;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class, SpringMvcConfig.class })
@WebAppConfiguration("src/main/webapp")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("../domain/Member.xml")
public class MemberDetailControllerIntTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void givenNotExistingMeberId_returnNoMemberView() throws Exception {
		mockMvc.perform(
				get("/admin/member/detail")
						.param("memberId", "100000")
				)
				.andExpect(status().isOk())
				.andExpect(view().name("admin/noMember"));
	}

	@Test
	public void givenExistingMemberId_returnMemberDetail() throws Exception {
		mockMvc.perform(
				get("/admin/member/detail")
						.param("memberId", "1")
				)
				.andExpect(status().isOk())
				.andExpect(view().name("admin/memberDetail"))
				.andExpect(model().attributeExists("member"));
	}
}
