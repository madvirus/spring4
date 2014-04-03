package net.madvirus.spring4.chap10.webconf;

import javax.servlet.Filter;

import net.madvirus.spring4.chap10.springconf.RootConfig;
import net.madvirus.spring4.chap10.springconf.WebConfig;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringServletConfig3
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	// 상위 클래스는 "dispatcher" 리턴
	@Override
	protected String getServletName() {
		return "dispatcher3"; // 기본 값은 "dispatcher"
	}

	// abstract 메서드 재정의
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.do" };
	}

	// 상위 클래스는 true 리턴
	@Override
	protected boolean isAsyncSupported() {
		return super.isAsyncSupported();
	}

	// 상위 클래스는 기본으로 null 리턴
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		Filter[] filters = new Filter[] { encodingFilter };
		return filters;
	}

}
