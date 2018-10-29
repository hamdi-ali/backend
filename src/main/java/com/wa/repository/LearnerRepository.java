package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.learner.Learner;

public interface LearnerRepository extends CrudRepository<Learner,Long>{
	
	public List<Learner> findAll();
	
	public Learner findByCin(long cin);
	
	public Learner findByUsername(String username);
	
}
