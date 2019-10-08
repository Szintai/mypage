package com.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypage.entity.User;
import com.mypage.repository.UserRepository;

@Service
public class UserService {

	
	UserRepository userRepo;

	
	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public void init() {
		
		User user=new User("emai@email.com", "Kereszt", "uto", "jelszo");
		
		userRepo.save(user);
		
	}
	
	public void addNewUser(User user)
	{
		userRepo.save(user);
		
	}
	
	
	
}
