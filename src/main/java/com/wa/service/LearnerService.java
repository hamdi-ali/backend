package com.wa.service;

import java.util.List;

import com.wa.domain.learner.Learner;

public interface LearnerService {
	
	List<Learner> findAll();
	
	Learner findOne(Long learnerId);
	
	public Learner findByCin(long cin);
	
	Learner save(Learner learner);
	
	void removeOne(Long id);

}
