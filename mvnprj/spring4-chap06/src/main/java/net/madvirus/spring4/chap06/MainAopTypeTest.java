package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.UpdateInfo;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAopTypeTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopTypeTest.xml");

		MemberService ms = ctx.getBean("memberService", MemberService.class);

		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("최범균");
		ms.update("madvirus", updateInfo);

		ctx.close();
	}
}
