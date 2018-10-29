package com.wa.service;

import java.util.Set;

import com.wa.domain.User;
import com.wa.domain.security.Role;


public interface UserService {
	
	User findByUserId(Long id);

	User findByUsername(String username);

	User findByEmail (String email);

	User save(User user);
		
	public Role saveRole(Role role);
	public void addRoleToUser(String username, String roleName);
	
	User createUser (User user, Set<Role> userRoles );
	
}
