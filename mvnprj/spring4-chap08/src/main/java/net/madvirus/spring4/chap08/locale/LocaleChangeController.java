package net.madvirus.spring4.chap08.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LocaleChangeController {

	private LocaleResolver localeResolver;

	@RequestMapping("/changeLanguage")
	public String change(@RequestParam("lang") String language,
			HttpServletRequest request, HttpServletResponse response) {
		Locale locale = new Locale(language);
		localeResolver.setLocale(request, response, locale);
		return "redirect:/index.jsp";
	}

	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

}
