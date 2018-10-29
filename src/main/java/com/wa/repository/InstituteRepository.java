package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.learner.Institute;

public interface InstituteRepository extends CrudRepository<Institute, Long>{
	
	public List<Institute> findAll();
	
	public Institute findByName(String name);

}

