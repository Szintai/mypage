package com.mypage.repository;

import org.springframework.data.repository.CrudRepository;

import com.mypage.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	
	Role findByRole(String role);
	
	
}
