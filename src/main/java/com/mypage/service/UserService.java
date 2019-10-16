package com.mypage.service;

import com.mypage.entity.User;

public interface UserService {
	
	public String registerUser(User user);
	
	public User findByEmail(String email);
	
	

}
