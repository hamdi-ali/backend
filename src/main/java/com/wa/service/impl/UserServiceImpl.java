package com.wa.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.User;
import com.wa.domain.security.Role;
import com.wa.repository.RoleRepository;
import com.wa.repository.UserRepository;
import com.wa.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {	
		return userRepository.save(user);
	}

	@Override
	public User findByUserId(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role=roleRepository.findByName(roleName);
		User user=userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Transactional
	public User createUser(User user, Set<Role> userRoles) {
		// TODO Auto-generated method stub
		User localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			LOG.info("User with username {} already exists. Nothing will be done .", user.getUsername());
			}
			else {
				for(Role ur: userRoles)
				roleRepository.save(ur.getName());
			}
			user.getRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		
		return localUser;
	}
}
