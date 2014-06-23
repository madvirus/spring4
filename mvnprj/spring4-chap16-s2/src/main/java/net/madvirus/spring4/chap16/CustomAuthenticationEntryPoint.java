package net.madvirus.spring4.chap16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.UrlUtils;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private String loginFormPath;

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		String redirectUrl = UrlUtils.buildFullRequestUrl(request);
		String encoded = response.encodeRedirectURL(redirectUrl);
		response.sendRedirect(request.getContextPath() + loginFormPath +
				"?returl=" + encoded);
	}

	public void setLoginFormPath(String loginPage) {
		this.loginFormPath = loginPage;
	}

}
