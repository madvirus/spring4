package net.madvirus.spring4.chap15.member.application;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import net.madvirus.spring4.chap15.conf.SpringAppConfig;
import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;

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
@DatabaseSetup("../domain/Member.xml")
public class NewMemberRegServiceIntTest {

	@Autowired
	private NewMemberRegService newMemberRegService;

	@Autowired
	private MemberRepository memberRepository;

	@Test(expected = DuplicateUserIdException.class)
	public void givenDupUserId_throwException() throws Exception {
		NewMemberRequest req = new NewMemberRequest();
		req.setUserId("madvirus");
		Long newMemberId = newMemberRegService.register(req);
		assertThat(newMemberId, greaterThan(1L));
	}

	@Test(expected = DuplicateEmailException.class)
	public void givenDupEmail_throwException() throws Exception {
		NewMemberRequest req = new NewMemberRequest();
		req.setUserId("madvirus2");
		req.setEmail("madvirus@madvirus.net");
		newMemberRegService.register(req);
	}

	@Test
	public void givenNewMember_shouldAdd() throws Exception {
		NewMemberRequest req = new NewMemberRequest();
		req.setName("최범균2");
		req.setUserId("madvirus2");
		req.setEmail("madvirus2@madvirus.net");
		req.setPassword("123456");
		Long newMemberId = newMemberRegService.register(req);

		Member newMember = memberRepository.findOne(newMemberId);
		assertThat(newMember, notNullValue());
		assertThat(newMember.getName(), equalTo("최범균2"));
		assertThat(newMember.getUserId(), equalTo("madvirus2"));
		assertThat(newMember.getEmail(), equalTo("madvirus2@madvirus.net"));
		assertThat(newMember.matchPassword("123456"), equalTo(true));
	}
}
