package net.madvirus.spring4.chap07.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/modify")
public class MemberModificationController {

	private static final String MEMBER_MODIFICATION_FORM = "member/modificationForm";
	private static final String MEMBER_NOT_FOUND_VIEW = "member/memberNotFound";
	private MemberService memberService;
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("modReq") MemberModRequest modReq,
			@RequestParam("mid") String memberId) {
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if (mi == null)
			return MEMBER_NOT_FOUND_VIEW;

		modReq.setId(mi.getId());
		modReq.setName(mi.getName());
		modReq.setEmail(mi.getEmail());
		modReq.setAllowNoti(mi.isAllowNoti());
		return MEMBER_MODIFICATION_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String modify(@Valid @ModelAttribute("modReq") MemberModRequest modReq, Errors errors) {
		if (errors.hasErrors()) {
			return MEMBER_MODIFICATION_FORM;
		}
		try {
			memberService.modifyMemberInfo(modReq);
			return "member/modified";
		} catch (NotMatchPasswordException ex) {
			errors.rejectValue("currentPassword", "invalidPassword");
			return MEMBER_MODIFICATION_FORM;
		} catch (MemberNotFoundException ex) {
			return MEMBER_NOT_FOUND_VIEW;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator); // jsr303validator를 검증기로 사용
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

}
