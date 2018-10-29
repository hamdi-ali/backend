package com.wa.service;

import java.util.List;

import com.wa.domain.Skill;

public interface SkillService {
	
	List<Skill> findAll();
	
	Skill findOne(Long id);
	
	Skill findByName(String name);
	
	Skill save(Skill skill);
	
	void removeOne(Long id);
	
}
