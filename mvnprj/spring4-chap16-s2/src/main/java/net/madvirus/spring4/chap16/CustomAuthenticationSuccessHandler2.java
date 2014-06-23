package net.madvirus.spring4.chap16;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler2
		implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, HttpServletResponse response,
			Authentication authentication)
			throws IOException, ServletException {
		addAuthCookie(response, authentication);
		String retUrl = request.getParameter("returl");
		if (retUrl == null || retUrl.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		response.sendRedirect(retUrl);
	}

	private void addAuthCookie(HttpServletResponse response, 
			Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String cookieValue = user.getUsername();
		if (authentication.getAuthorities() != null) {
			for (GrantedAuthority auth : authentication.getAuthorities())
				cookieValue += "," + auth.getAuthority();
		}
		try {
			// 실제로는 쿠키값을 암호화해서 저장한다.
			Cookie cookie = new Cookie("AUTH", 
					URLEncoder.encode(cookieValue, "utf-8"));
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
