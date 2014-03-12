package net.madvirus.spring4.chap08.auth;

import net.madvirus.spring4.chap08.member.MemberInfo;
import net.madvirus.spring4.chap08.member.MemberService;

public class Authenticator {

	private MemberService memberService;

	public Authenticator(MemberService memberService) {
		this.memberService = memberService;
	}

	public Auth authenticate(String email, String password) {
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if (mi == null)
			throw new AuthenticationException();
		if (!mi.matchPassword(password))
			throw new AuthenticationException();

		return new Auth(mi.getId(), mi.getName());
	}
}
