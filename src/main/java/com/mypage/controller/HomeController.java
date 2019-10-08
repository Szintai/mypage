package com.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mypage.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	
	
	
	@RequestMapping("/")
	public String index()
	{
		
		saveUser();
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login()
	{
		
		
		return "login";
	}
	
	
	
	@RequestMapping("/registration")
	public String registration()
	{
		
		
		return "registration";
	}
	
	public void saveUser() {
		
		userService.init();
		
	}
	
	
	
	
}
