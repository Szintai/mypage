package com.mypage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
		
/*		auth
		   .inMemoryAuthentication()
		     .withUser("user")
		     .password("{noop}pass")
		     .roles("USER")
		    .and()
		     .withUser("admin")
		     .password("{noop}pass")
		     .roles("ADMIN");
		*/
		
		
	}
	

	protected void configure(HttpSecurity httpSec) throws Exception{
		
		httpSec
		.authorizeRequests()
		  .regexMatchers(".*\\.css$").permitAll()
		  .antMatchers("/db/*").permitAll()
	 	  .antMatchers("/db/**").permitAll()
		  .antMatchers("/registration").permitAll()
		  .antMatchers("/reg").permitAll()
	   	  .antMatchers("/login").permitAll()
		  .anyRequest().authenticated()
		  .and()
	.formLogin()
	  .loginPage("/login")
	  .permitAll()
	  .and()
    .logout()
      .logoutSuccessUrl("/login?logout")
	  .permitAll();
		
		httpSec.csrf().disable();
        httpSec.headers().frameOptions().disable();
		
		
	}
	
	
	
}
