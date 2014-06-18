package net.madvirus.spring4.chap16.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/register")
public class JoinController {

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "user/registerForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("newUser") NewUser newUser, Errors errors) {
		new NewUserValidator().validate(newUser, errors);
		if (errors.hasErrors())
			return "user/joinForm";
		return "user/join";
	}

}
