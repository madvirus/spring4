package net.madvirus.spring4.chap16;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

public class CustomSecurityContextRepository implements SecurityContextRepository {

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder reqResHolder) {
		SecurityContext ctx = SecurityContextHolder.createEmptyContext();
		String authValue = getAuthCookieValue(reqResHolder.getRequest());
		if (authValue != null) {
			String[] values = authValue.split(",");
			String userName = values[0];
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (int i = 1; i < values.length; i++) {
				authorities.add(new SimpleGrantedAuthority(values[i]));
			}
			User user = new User(userName, "", authorities);
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(user, null, authorities);
			ctx.setAuthentication(authentication);
		}
		return ctx;
	}

	private String getAuthCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("AUTH")) {
				try {
					return URLDecoder.decode(cookie.getValue(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public void saveContext(SecurityContext context, 
			HttpServletRequest request, HttpServletResponse response) {
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		return false;
	}

}
