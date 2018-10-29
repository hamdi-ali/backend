package com.wa.service;

import java.util.List;

import com.wa.domain.Group;

public interface GroupService 
{
	List<Group> findAll();
	
	Group findOne(Long groupId);
	
	Group findByName(String name);
	
	Group save(Group skill);
	
	void removeOne(Long id);
	
}
