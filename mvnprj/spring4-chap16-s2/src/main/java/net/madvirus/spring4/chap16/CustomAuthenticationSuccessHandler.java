package net.madvirus.spring4.chap16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, HttpServletResponse response,
			Authentication authentication)
			throws IOException, ServletException {
		String retUrl = request.getParameter("returl");
		if (retUrl == null || retUrl.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		response.sendRedirect(retUrl);
	}

}
