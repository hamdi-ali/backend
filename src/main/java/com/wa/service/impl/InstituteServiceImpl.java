package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.learner.Institute;
import com.wa.repository.InstituteRepository;
import com.wa.service.InstituteService;


@Transactional
@Service
public class InstituteServiceImpl implements InstituteService{
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	@Override
	public List<Institute> findAll() {
		return instituteRepository.findAll();
	}

	@Override
	public Institute save(Institute institute) {
		return instituteRepository.save(institute);
	}
}
