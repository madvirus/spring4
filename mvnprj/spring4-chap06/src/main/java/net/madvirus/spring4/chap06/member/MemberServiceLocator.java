package net.madvirus.spring4.chap06.member;

public class MemberServiceLocator {

	private MemberServiceImpl memberService;

	public MemberServiceImpl getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

}
