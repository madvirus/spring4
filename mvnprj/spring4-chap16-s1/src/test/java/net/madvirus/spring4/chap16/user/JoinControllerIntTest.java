package net.madvirus.spring4.chap16.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import net.madvirus.spring4.chap16.base.AbstractWebMvcIntTest;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

public class JoinControllerIntTest extends AbstractWebMvcIntTest {

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
	@ExpectedDatabase(value = "NewUserAdded.xml",
			assertionMode = DatabaseAssertionMode.NON_STRICT,
			table = "users",
			query = "select * from users where username='madvirus'")
	public void return_SuccessView_By_Post_With_Valid_Param() throws Exception {
		mockMvc.perform(createPostRequest("madvirus", "1111", "1111"))
				.andDo(print())
				.andExpect(view().name(JoinController.USER_JOIN_SUCCESS));
	}
}
