package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.Group;

public interface GroupRepository extends CrudRepository<Group, Long>{
	
	public List<Group> findAll();
	
	Group findByName(String name);

}
