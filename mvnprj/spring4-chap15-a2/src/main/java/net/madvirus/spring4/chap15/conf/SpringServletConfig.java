package net.madvirus.spring4.chap15.conf;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		return new Filter[] { encodingFilter };
//		OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
//		osivFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
//
//		Filter[] filters = new Filter[] { encodingFilter, osivFilter };
//		return filters;
	}

}
