package net.madvirus.spring4.chap16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler
		implements AuthenticationFailureHandler {

	private String loginFormPath;

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception)
			throws IOException, ServletException {
		request.getRequestDispatcher(loginFormPath).forward(request, response);
	}

	public void setLoginFormPath(String loginFormPath) {
		this.loginFormPath = loginFormPath;
	}

}
