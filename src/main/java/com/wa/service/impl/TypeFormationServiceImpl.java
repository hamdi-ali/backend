package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.TypeFormation;
import com.wa.repository.TypeFormationRepository;
import com.wa.service.TypeFormationService;

@Transactional
@Service
public class TypeFormationServiceImpl implements TypeFormationService{
	
	@Autowired
	private TypeFormationRepository typeFormationRepository;

	@Override
	public List<TypeFormation> findAll() {
		return typeFormationRepository.findAll();
	}

	@Override
	public TypeFormation save(TypeFormation typeFormation) {
		return typeFormationRepository.save(typeFormation);
	}
}
