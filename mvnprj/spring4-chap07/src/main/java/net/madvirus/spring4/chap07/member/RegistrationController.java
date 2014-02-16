package net.madvirus.spring4.chap07.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	private MemberService memberService;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "member/registrationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		memberService.registNewMember(memRegReq);
		return "member/registered";
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
