package com.mypage.service;

import javax.management.relation.RoleResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypage.entity.Role;
import com.mypage.entity.User;
import com.mypage.repository.RoleRepository;
import com.mypage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService , UserService{

	
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	private final String USER_ROLE = "USER";
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		
		log.info("semmi"+username);
		
		User user = findByEmail(username);
		
		log.info(user.getEmail());

		if(user == null)
		{throw new UsernameNotFoundException(username);}
			
		return new UserDetailsImpl(user);
	}
	
	
	public User findByEmail(String email) {
		
		
		return userRepo.findByEmail(email);
	}

	@Override
	public String registerUser(User userToRegister) {
		
		User userCheck = userRepo.findByEmail(userToRegister.getEmail());
		
		if(userCheck != null)
		{
		  return "alreadyExists";	
		}
		try {
		Role userRole =  roleRepo.findByRole(USER_ROLE);
		
		
		if(userRole != null)
		{
			userToRegister.getRoles().add(userRole);
		}else {
			userToRegister.addRoles(USER_ROLE);
		}
			
		}catch(Exception ex) {}
		
		userToRegister.setEnabled(false);
			
		userRepo.save(userToRegister);
		
		
		
		
		return "ok";
	}

	@Override
	public String userActivation(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
