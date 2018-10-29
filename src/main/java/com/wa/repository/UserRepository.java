package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	

}
