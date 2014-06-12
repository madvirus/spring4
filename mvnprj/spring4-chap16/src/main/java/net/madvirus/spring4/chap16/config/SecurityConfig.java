package net.madvirus.spring4.chap16.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("bkchoi").password("1234").roles().and()
				.withUser("manager").password("qwer").roles("MANAGER").and()
				.withUser("admin").password("asdf").authorities("ROLE_ADMIN", "ROLE_MANAGER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")
				.antMatchers("/member/**").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.and()
			.logout();
	}

}
