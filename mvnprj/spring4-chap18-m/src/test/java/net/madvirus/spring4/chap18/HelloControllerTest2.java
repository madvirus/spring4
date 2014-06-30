package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HelloControllerTest2 {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController())
				.setViewResolvers(viewResolver)
				.build();
	}

	@Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "bkchoi"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("greeting"));
	}

	@Test
	public void testHelloJson() throws Exception {
		mockMvc.perform(post("/hello.json")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"최범균\"}")
				)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(cookie().doesNotExist("UAC"))
				.andExpect(jsonPath("$.greeting", equalTo("안녕하세요, 최범균")));
	}
}
