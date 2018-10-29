package com.wa.service;

import java.util.List;

import com.wa.domain.Training;

public interface TrainingService {
	
	List<Training> findAll();
	
	Training findOne(Long id);
	
	Training findByName(String name);
	
	Training save(Training training);
	
	Training update(Training training);
	
	void removeOne(Long id);
}
