package net.madvirus.spring4.chap09.config;

import java.util.List;

import net.madvirus.spring4.chap09.gm.GuestMessageController;
import net.madvirus.spring4.chap09.mc.SimpleConverterController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class SampleConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new StringHttpMessageConverter());
		converters.add(new Jaxb2RootElementHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	@Bean
	public SimpleConverterController simple() {
		return new SimpleConverterController();
	}

	@Bean
	public GuestMessageController guestMessageController() {
		return new GuestMessageController();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver result = new InternalResourceViewResolver();
		result.setPrefix("/WEB-INF/view/");
		result.setSuffix(".jsp");
		return result;
	}

}
