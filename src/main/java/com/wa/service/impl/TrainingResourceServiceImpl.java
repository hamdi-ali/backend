package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.domain.TrainingResource;
import com.wa.repository.TrainingResourceRepository;
import com.wa.service.TrainingResourceService;

@Service
public class TrainingResourceServiceImpl implements TrainingResourceService{
	
	@Autowired
	private TrainingResourceRepository trainingResourceRepository;
	
	public List<TrainingResource> findAll(){
		return trainingResourceRepository.findAll();
	}

	@Override
	public TrainingResource save(TrainingResource support) {
		return trainingResourceRepository.save(support);
	}

	@Override
	public void removeOne(Long id) {
		this.trainingResourceRepository.delete(id);
	}
	
	@Override
	public TrainingResource findByTitle(String title){
		return this.trainingResourceRepository.findByTitle(title);
	}

}
