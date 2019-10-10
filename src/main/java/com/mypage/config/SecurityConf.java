package com.mypage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity httpSec) throws Exception{
		
		httpSec
		.authorizeRequests()
		.regexMatchers(".*\\.css$").permitAll()
		.antMatchers("/registration").permitAll()
		.antMatchers("/reg").permitAll()
		.and()
	.formLogin()
	.loginPage("/login")
	.permitAll();
		
		
	}
	
	
	
}
