package com.mypage.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
//@Table(name="roles")
public class Role {
	
//	@Id @GeneratedValue
	private Long id;
	
	private String role;
	
	private Set<User> users=new HashSet<User>();
	
	private Role() {}
	
	

}
