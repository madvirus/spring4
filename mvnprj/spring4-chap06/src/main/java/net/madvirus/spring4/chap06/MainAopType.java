package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.config.AopConfig;
import net.madvirus.spring4.chap06.config.NoAopConfig;
import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.MemberServiceImpl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAopType {

	public static void main(String[] args) {
		useNoAop();
		useAop();
	}

	private static void useNoAop() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(NoAopConfig.class);

		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService); // true
		System.out.println(ms instanceof MemberServiceImpl); // true

		ctx.close();
	}
	
	private static void useAop() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AopConfig.class);
		
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService); // true
		System.out.println(ms instanceof MemberServiceImpl); // false
		System.out.println(ms.getClass().getName());
		
		ctx.close();
	}
}
