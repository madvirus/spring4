package net.madvirus.spring4.chap07.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "member/registrationForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String regist() {
		return "member/registered";
	}
}
