package net.madvirus.spring4.chap08.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LocaleChangeController2 {

	@RequestMapping("/changeLanguage2")
	public String change(@RequestParam("lang") String language,
			HttpServletRequest request, HttpServletResponse response) {
		Locale locale = new Locale(language);
		LocaleResolver localeResolver = RequestContextUtils
                .getLocaleResolver(request);

		localeResolver.setLocale(request, response, locale);
		return "redirect:/index.jsp";
	}

}
