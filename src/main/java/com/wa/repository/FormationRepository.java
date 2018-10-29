package com.wa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wa.domain.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long>{

	public List<Formation> findAll();
	
	Formation findByLabel(String label);
}
