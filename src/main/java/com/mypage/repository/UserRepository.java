package com.mypage.repository;



import org.springframework.data.repository.CrudRepository;

import com.mypage.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	
	

}
