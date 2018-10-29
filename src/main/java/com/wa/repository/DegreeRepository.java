package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.learner.Degree;

public interface DegreeRepository extends CrudRepository<Degree, Long>{
	
	public List<Degree> findAll();
	
	Degree findByName(String name);

}
