package net.madvirus.spring4.chap18;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-mvc.xml")
@WebAppConfiguration
public class BookControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testBooksJson() throws Exception {
		mockMvc.perform(get("/books.json"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.books[2].title", equalTo("제목3")))
				.andExpect(jsonPath("$.books").exists())
				.andExpect(jsonPath("$.books").isArray())
				.andExpect(jsonPath("$.books").value(hasSize(3)))
				.andExpect(jsonPath("$.books[0].title").value("제목1"))
				.andExpect(
						jsonPath("$.books[%d].price", 0).value(equalTo(1000)))
				.andExpect(jsonPath("$.books[1].%s", "price").value(2000));
	}

	@Test
	public void testBooksXml() throws Exception {
		mockMvc.perform(get("/books.xml"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(xpath("/book-list/book[3]/title").string("제목3"))
				.andExpect(xpath("/book-list/book[3]/%s", "price").number(3000.0));
	}
}
