package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.Skill;


public interface SkillRepository extends CrudRepository<Skill,Long>{

	List<Skill> findAll();
	
	Skill findByName(String name);

}
