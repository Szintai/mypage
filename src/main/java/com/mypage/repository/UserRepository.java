package com.mypage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mypage.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	User findByEmail(String email);

}
