package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.learner.Degree;
import com.wa.repository.DegreeRepository;
import com.wa.service.DegreeService;

@Transactional
@Service
public class DegreeServiceImpl implements DegreeService{
	
	@Autowired
	private DegreeRepository degreeRepository;
	

	@Override
	public List<Degree> findAll() {
		return degreeRepository.findAll();
	}

	@Override
	public Degree save(Degree degree) {
		return degreeRepository.save(degree);
	}
	
}
