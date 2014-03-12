package net.madvirus.spring4.chap08.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth/login")
public class LoginController {

	private static final String LOGIN_FORM = "auth/loginForm";
	private Authenticator authenticator;

	@ModelAttribute("loginTypes")
	protected List<String> referenceData() {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand) {
		loginCommand.setSecurityLevel(SecurityLevel.HIGH);
		return LOGIN_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@Valid LoginCommand loginCommand, Errors errors,
			HttpServletRequest request) {
		if (errors.hasErrors()) {
			return LOGIN_FORM;
		}
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("auth", auth);
			return "redirect:/index.jsp";
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword");
			return LOGIN_FORM;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

}
