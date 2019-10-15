package com.mypage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypage.entity.User;
import com.mypage.service.UserService;

@Controller
public class HomeController {

	
	private UserService userService;
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	

    @Autowired
	public HomeController(UserService userService) {
	
		this.userService = userService;
	}



	@RequestMapping("/")
	public String index()
	{
		return "index";
	}

	
	
	@RequestMapping("/registration")
	public String registration(Model model)
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	
	@PostMapping("/reg")
	public String reg(@ModelAttribute User user)
	{
		log.info("új user");
		log.info(user.getEmail());
		
		userService.registerUser(user);
		
		return "auth/login";
		
	}
	
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
