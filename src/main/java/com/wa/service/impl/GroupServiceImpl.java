package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.Group;
import com.wa.repository.GroupRepository;
import com.wa.service.GroupService;

@Transactional
@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return this.groupRepository.findAll();
	}
	
	@Override
	public Group findOne(Long groupId) {
		return this.groupRepository.findOne(groupId);
	}
	
	@Override
	public Group findByName(String name) {
		
		return this.groupRepository.findByName(name);
	}

	@Override
	public Group save(Group group) {
		return this.groupRepository.save(group);
	}

	@Override
	public void removeOne(Long id) {
		this.groupRepository.delete(id);
	}	
}
