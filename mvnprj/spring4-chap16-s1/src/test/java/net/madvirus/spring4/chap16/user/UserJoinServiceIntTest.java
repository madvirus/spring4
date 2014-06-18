package net.madvirus.spring4.chap16.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

@ContextConfiguration({ "classpath:/spring-security-s1.xml", "classpath:/spring-application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "/UserAuthorities.xml")
public class UserJoinServiceIntTest {

	@Autowired
	private UserJoinService userJoinService;

	@Test
	@ExpectedDatabase(value = "NewUserAdded.xml", table = "users", query = "select * from users where username='madvirus'")
	public void newUser_Join_Successfully() throws Exception {
		NewUser newUser = new NewUser();
		newUser.setName("madvirus");
		newUser.setPassword("1111");
		userJoinService.join(newUser);
	}

	@Test(expected = DuplicateUsernameException.class)
	public void throw_Exception_When_DupUsername_Is_Used() throws Exception {
		NewUser newUser = new NewUser();
		newUser.setName("admin");
		newUser.setPassword("1111");
		userJoinService.join(newUser);
	}

}
