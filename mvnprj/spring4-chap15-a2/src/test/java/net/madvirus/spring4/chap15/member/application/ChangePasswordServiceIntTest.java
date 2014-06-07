package net.madvirus.spring4.chap15.member.application;

import static org.junit.Assert.fail;
import net.madvirus.spring4.chap15.conf.SpringAppConfig;
import net.madvirus.spring4.chap15.member.domain.WrongPasswordException;

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

@ContextConfiguration(classes = SpringAppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class ChangePasswordServiceIntTest {

	@Autowired
	private ChangePasswordService changePasswordService;

	@DatabaseSetup("../domain/Member.xml")
	@Test
	public void givenMathingPw_Success() {
		try {
			changePasswordService.changePassword(createRequest(1L, "abcd", "5678"));
		} catch (WrongPasswordException ex) {
			fail("발생하면 안 됨");
		}
	}

	private ChangePasswordRequest createRequest(long memberId, String currentPw, String newPw) {
		ChangePasswordRequest req = new ChangePasswordRequest();
		req.setMemberId(memberId);
		req.setCurrentPassword(currentPw);
		req.setNewPassword(newPw);
		return req;
	}

	@DatabaseSetup("../domain/Member.xml")
	@Test(expected = MemberNotFoundException.class)
	public void givenNoneMemberId_throwException() {
		changePasswordService.changePassword(createRequest(-1L, "1234", "5678"));
	}

	@DatabaseSetup("../domain/Member.xml")
	@Test(expected = WrongPasswordException.class)
	public void givenNotMatchingPw_throwException() {
		changePasswordService.changePassword(createRequest(1L, "2222", "5678"));
	}
}
