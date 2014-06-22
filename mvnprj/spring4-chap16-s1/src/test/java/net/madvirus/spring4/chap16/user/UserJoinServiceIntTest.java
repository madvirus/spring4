package net.madvirus.spring4.chap16.user;

import net.madvirus.spring4.chap16.base.AbstractIntTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

public class UserJoinServiceIntTest extends AbstractIntTest {

	@Autowired
	private UserJoinService userJoinService;

	@Test
	@ExpectedDatabase(value = "NewUserAdded.xml",
			assertionMode = DatabaseAssertionMode.NON_STRICT,
			table = "users",
			query = "select * from users where username='madvirus'")
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
