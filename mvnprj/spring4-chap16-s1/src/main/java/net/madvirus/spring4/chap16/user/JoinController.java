package net.madvirus.spring4.chap16.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/join")
public class JoinController {
	public static final String USER_JOIN_SUCCESS = "user/joinSuccess";
	public static final String USER_JOIN_FORM = "user/joinForm";

	private UserJoinService userJoinService;

	@ModelAttribute("newUser")
	public NewUser formBacking() {
		return new NewUser();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return USER_JOIN_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("newUser") NewUser newUser, Errors errors) {
		new NewUserValidator().validate(newUser, errors);
		if (errors.hasErrors())
			return USER_JOIN_FORM;
		try {
			userJoinService.join(newUser);
			return USER_JOIN_SUCCESS;
		} catch (DuplicateUsernameException ex) {
			errors.rejectValue("name", "duplicate");
			return USER_JOIN_FORM;
		}
	}

	public void setUserJoinService(UserJoinService userJoinService) {
		this.userJoinService = userJoinService;
	}

}
