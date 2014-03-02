package net.madvirus.spring4.chap07.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("mi.beginTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Long beginTime = (Long) request.getAttribute("mi.beginTime");
		long endTime = System.currentTimeMillis();
		System.out.println(request.getRequestURI() + " 실행 시간: " + (endTime - beginTime));
	}

}
