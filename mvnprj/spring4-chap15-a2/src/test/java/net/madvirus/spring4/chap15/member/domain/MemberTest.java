package net.madvirus.spring4.chap15.member.domain;

import static org.junit.Assert.fail;

import org.junit.Test;

public class MemberTest {

	@Test(expected = WrongPasswordException.class)
	public void changePassword_ThrowException_giveNoMatchingPw() throws Exception {
		Member m = new Member("madvirus", "1234", "madvirus@madvirus.net", "최범균");
		m.changePassword("1111", "4321");
	}

	@Test
	public void changePassword_run_successfully_giveMatchingPw() throws Exception {
		Member m = new Member("madvirus", "1234", "madvirus@madvirus.net", "최범균");
		m.changePassword("1234", "4321");
		try {
			m.changePassword("1234", "1111");
			fail("익셉션 발생해야 함!");
		} catch(WrongPasswordException ex) {
		}
		try {
			m.changePassword("4321", "1111");
		} catch(WrongPasswordException ex) {
			fail("익셉션 발생하면 안 됨!");
		}
	}
}
