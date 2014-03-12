package net.madvirus.spring4.chap08.member;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {
	private static final String MEMBER_REGISTRATION_FORM = "member/registrationForm";

	private MemberService memberService;

	@ModelAttribute("jobCodes")
	public List<Code> jobCodes() {
		return Arrays.asList(
				new Code("1", "운동선수"),
				new Code("2", "프로그래머"),
				new Code("3", "예술가"),
				new Code("4", "작가")
				);
	}

	@ModelAttribute("favoriteOsNames")
	public List<String> favoriteOs() {
		return Arrays.asList("윈도우XP", "윈도우7", "윈도우8", "맥OS", "우분투");
	}

	@ModelAttribute("tools")
	public List<String> tools() {
		return Arrays.asList("이클립스", "인텔리J", "넷빈즈", "Vim");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		return MEMBER_REGISTRATION_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(
			@ModelAttribute("memberInfo") MemberRegistRequest memRegReq,
			BindingResult bindingResult) {
		new MemberRegistValidator().validate(memRegReq, bindingResult);
		if (bindingResult.hasErrors()) {
			return MEMBER_REGISTRATION_FORM;
		}
		memberService.registNewMember(memRegReq);
		return "member/registered";
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
