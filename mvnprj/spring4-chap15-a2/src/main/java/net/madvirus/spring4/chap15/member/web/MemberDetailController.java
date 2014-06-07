package net.madvirus.spring4.chap15.member.web;

import net.madvirus.spring4.chap15.member.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberDetailController {

	@Autowired
	private DataLoader dataLoader;

	@RequestMapping("/admin/member/detail")
	public String detail(@RequestParam("memberId") Long memberId, Model model) {
		Member member = dataLoader.loadMember(memberId);
		if (member == null)
			return "admin/noMember";
		model.addAttribute("member", member);
		return "admin/memberDetail";
	}
}
