package com.wa.service;

import java.util.List;

import com.wa.domain.learner.Degree;

public interface DegreeService {
	
	List<Degree> findAll();
	
	Degree save(Degree degree);
}
