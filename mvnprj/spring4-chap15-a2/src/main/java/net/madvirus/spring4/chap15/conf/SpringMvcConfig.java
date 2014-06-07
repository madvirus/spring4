package net.madvirus.spring4.chap15.conf;

import net.madvirus.spring4.chap15.member.application.ChangePasswordService;
import net.madvirus.spring4.chap15.member.web.ChangePasswordController;
import net.madvirus.spring4.chap15.member.web.MemberDetailController;

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
	private ChangePasswordService changePasswordService;

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
	public ChangePasswordController changePasswordController() {
		ChangePasswordController controller = new ChangePasswordController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}

	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		return controller;
	}

}
