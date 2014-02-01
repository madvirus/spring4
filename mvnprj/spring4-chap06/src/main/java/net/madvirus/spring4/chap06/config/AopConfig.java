package net.madvirus.spring4.chap06.config;

import net.madvirus.spring4.chap06.aop.UpdateMemberInfoTraceAspect;
import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.MemberServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}

}
