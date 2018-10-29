package com.wa.service;

import java.util.List;

import com.wa.domain.TrainingResource;


public interface TrainingResourceService {
	
	List<TrainingResource> findAll();
	
	TrainingResource findByTitle(String title);
	
	TrainingResource save(TrainingResource trainingResource);
	
	void removeOne(Long id);

}
