package com.wa.repository;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long>{
	
	public Role findByName(String roleName);

	public void save(String string);
	 

}
