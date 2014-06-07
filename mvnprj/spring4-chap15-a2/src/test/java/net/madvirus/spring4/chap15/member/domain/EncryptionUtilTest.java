package net.madvirus.spring4.chap15.member.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EncryptionUtilTest {

	@Test
	public void test_abcd() throws Exception {
		assertThat(EncryptUtil.encrypt("abcd"), equalTo("61626364"));
	}
}
