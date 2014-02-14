package net.madvirus.spring4.chap07.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	private Map<String, MemberInfo> memberMap = new HashMap<>();

	public MemberController() {
		memberMap.put("speed_sanghwa", new MemberInfo("speed_sanghwa", "이상화"));
		memberMap.put("yuna", new MemberInfo("yuna", "김연아"));
	}

	@RequestMapping("/members")
	public String members(Model model) {
		List<MemberInfo> members = getMembers();
		model.addAttribute("members", members);
		return "member/members";
	}

	private List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}

	@RequestMapping("/members/{memberId}")
	public String memberDetail(@PathVariable String memberId, Model model) {
		MemberInfo mi = getMemberInfo(memberId);
		if (mi == null) {
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		return "member/memberDetail";
	}

	private MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}

	@RequestMapping("/members/{memberId}/orders")
	public String memberOrders(@PathVariable("memberId") String memberId, Model model) {
		MemberInfo mi = getMemberInfo(memberId);
		if (mi == null) {
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		model.addAttribute("orders", getOrdersOfMember(memberId));
		return "member/memberOrders";
	}

	private List<OrderInfo> getOrdersOfMember(String memberId) {
		return Arrays.asList(
				new OrderInfo(1L, 10000, memberId),
				new OrderInfo(2L, 15000, memberId)
				);
	}

	@RequestMapping("/members/{memberId}/orders/{orderId}")
	public String memberOrderDetail(@PathVariable("memberId") String memberId,
			@PathVariable("orderId") Long orderId,
			Model model) {
		model.addAttribute("member", getMemberInfo(memberId));		
		model.addAttribute("order", new OrderInfo(orderId, orderId.intValue() * 5000 + 5000, memberId));
		return "member/memberOrderDetail";
	}
}
