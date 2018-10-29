package com.wa.service;

import java.util.List;

import com.wa.domain.learner.Institute;

public interface InstituteService {
	
	List<Institute> findAll();
	
	Institute save(Institute institute);
}
