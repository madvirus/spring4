package net.madvirus.spring4.chap06.config;

import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.MemberServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoAopConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}

}
