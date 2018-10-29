package com.wa.service;

import java.util.List;

import com.wa.domain.Formation;

public interface FormationService {
	
	List<Formation> findAll();
	
	Formation findByLabel(String label);
	
	Formation save(Formation formation);
	
	void removeOne(Long id);
}
