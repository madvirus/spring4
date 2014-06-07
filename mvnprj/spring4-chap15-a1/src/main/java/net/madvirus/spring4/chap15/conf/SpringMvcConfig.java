package net.madvirus.spring4.chap15.conf;

import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryService;
import net.madvirus.spring4.chap15.hr.web.EmployeeRegController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private EmployeeRegistryService employeeRegistryService;

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver result = new InternalResourceViewResolver();
		result.setPrefix("/WEB-INF/view/");
		result.setSuffix(".jsp");
		return result;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.error");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

	@Bean
	public EmployeeRegController employeeRegController() {
		EmployeeRegController controller = new EmployeeRegController();
		controller.setEmployeeRegistryService(employeeRegistryService);
		return controller;
	}

}
