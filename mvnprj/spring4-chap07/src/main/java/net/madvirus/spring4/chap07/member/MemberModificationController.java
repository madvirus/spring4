package net.madvirus.spring4.chap07.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/modify")
public class MemberModificationController {

	private static final String MEMBER_MODIFICATION_FORM_view = "member/modificationForm";
	private static final String MEMBER_NOT_FOUND_VIEW = "member/memberNotFound";
	private MemberService memberService;

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
		return MEMBER_MODIFICATION_FORM_view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String modify(@ModelAttribute("modReq") MemberModRequest modReq) {
		try {
			memberService.modifyMemberInfo(modReq);
			return "member/modified";
		} catch (NotMatchPasswordException ex) {
			return MEMBER_MODIFICATION_FORM_view;
		} catch (MemberNotFoundException ex) {
			return MEMBER_NOT_FOUND_VIEW;
		}
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
