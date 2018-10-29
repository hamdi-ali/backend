package com.wa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wa.domain.Formation;
import com.wa.repository.FormationRepository;
import com.wa.service.FormationService;

@Transactional
@Service
public class FormationServiceImpl implements FormationService{
	
	@Autowired 
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		return this.formationRepository.findAll();
	}

	@Override
	public Formation findByLabel(String label) {
		return this.formationRepository.findByLabel(label);
	}

	@Override
	public Formation save(Formation formation) {
		return this.formationRepository.save(formation);
	}

	@Override
	public void removeOne(Long id) {
		this.formationRepository.delete(id);
	}

}
